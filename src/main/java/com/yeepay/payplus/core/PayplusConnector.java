package com.yeepay.payplus.core;

import com.yeepay.g3.sdk.yop.client.YopClient;
import com.yeepay.g3.sdk.yop.client.YopRequest;
import com.yeepay.g3.sdk.yop.client.YopResponse;
import com.yeepay.g3.sdk.yop.error.YopError;
import com.yeepay.g3.sdk.yop.error.YopSubError;
import com.yeepay.g3.utils.common.json.JSONException;
import com.yeepay.g3.utils.common.json.JSONObject;
import com.yeepay.payplus.bo.BaseBO;
import com.yeepay.payplus.core.entity.PayplusResp;
import com.yeepay.payplus.exception.PayplusConfigException;
import com.yeepay.payplus.util.PayplusConfig;
import com.yeepay.payplus.util.PayplusUtil;
import org.apache.commons.beanutils.PropertyUtilsBean;
import org.apache.log4j.Logger;

import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;

/**
 * Created by Marco on 15/12/2016.
 */
public class PayplusConnector {

    private Logger logger = Logger.getLogger(PayplusConnector.class);

    private YopRequest request;

    //specify path related to payplus.properties
    public PayplusConnector(String path) {
        //load pp-sdk configuration depending on value of ENVIRONMENT in config file
        PayplusConfig.init(path);
        instanceYOPRequest(PayplusConfig.APP_KEY, PayplusConfig.APP_SECRET, PayplusConfig.ADDRESS, PayplusConfig.SIGN_ALGORITHM);
    }

    /**
     * payplus.properties is under general environment path
     * if not, please using constructor with a path parameter
     */
    public PayplusConnector() {
        //load pp-sdk configuration depending on value of ENVIRONMENT in config file
        PayplusConfig.init(null);
        instanceYOPRequest(PayplusConfig.APP_KEY, PayplusConfig.APP_SECRET, PayplusConfig.ADDRESS, PayplusConfig.SIGN_ALGORITHM);
    }

    // express constructor for SELF test, and the value of MODEL in cfg.properties should be SELF.
    public PayplusConnector(String appKey,String appSecret) {
        PayplusConfig.init(null);
        //under PRODUCT model, this method cannot be allowed.
        if(PayplusConfig.MODEL.equals("CUSTOMERS")){
            throw new PayplusConfigException("DEPRECATED, PLEASE USING THE CONSTRUCTOR WITHOUT PARAMETERS OR WITHIN A PATH PARAMETER.");
        }
        instanceYOPRequest(appKey, appSecret, PayplusConfig.ADDRESS, PayplusConfig.SIGN_ALGORITHM);
    }

    private void instanceYOPRequest(String appKey, String appSecret, String url, String signAlgorithm) {

        request = new YopRequest(appKey, appSecret, url);

        request.setEncrypt(true);
        request.setSignRet(true);
        request.setSignAlg(signAlgorithm);
    }

    private String formattedRequestParameters(Map<String, String> paras, String uri) {

        Set keys = paras.keySet();
        StringBuilder parameters = new StringBuilder("\n[Request of Payplus]\n");

        //assemble formatted output of URI
        uri = uri.substring(uri.indexOf("payplus") + 8);
        parameters.append("service: " + uri + "\n");

        Iterator it = keys.iterator();
        while (it.hasNext()) {
            String key = (String) it.next();
            Object value = paras.get(key);

            if (PayplusUtil.isNull(value))
                continue;

            parameters.append(key + ": " + value + "\n");
        }

        return parameters.toString();
    }

    public PayplusResp call(String uri, Map<String, String> paras) {

        PayplusResp payplusResp = new PayplusResp();

        //set YOPRequest up
        setUpYOPRequest(request, paras);

        //equip requestNo, activeNo with Trophy object for users' convenience
        if (paras.containsKey("requestNo"))
            payplusResp.setRequestNo(paras.get("requestNo"));
        else if (paras.containsKey("activeNo"))
            payplusResp.setActiveNo(paras.get("activeNo"));

        logger.debug(formattedRequestParameters(paras, uri));

        YopResponse resp = YopClient.post(uri, request);

        String state = resp.getState();

        JSONObject jo = null;

        if ("FAILURE".equals(state)) {

            YopError err = resp.getError();

            try {

                jo = new JSONObject();
                jo.put("code", err.getCode());
                jo.put("message", err.getMessage());

                JSONObject subErr = new JSONObject();

                List<YopSubError> errList = err.getSubErrors();

                for (YopSubError yopSubError : errList) {
                    subErr.put(yopSubError.getCode(), yopSubError.getMessage());
                }

                jo.put("subErrors", subErr);
                payplusResp.setRespInfo(jo.toString(2));
                payplusResp.setState(0);

            } catch (JSONException e) {
                e.printStackTrace();
            }

        } else if ("SUCCESS".equals(state)) {

            try {
                jo = new JSONObject(resp.getStringResult());

                if (jo.has("redirectUrl")) {
                    payplusResp.setKeyInfo(String.valueOf(jo.get("redirectUrl")));
                }

                payplusResp.setRespInfo(jo.toString(2));
                payplusResp.setState(1);

            } catch (JSONException e) {
                e.printStackTrace();
            }
        }

        return payplusResp;
    }

    public PayplusResp call(String uri, BaseBO bo) {
        return call(uri, convert2Map(bo));
    }

    /**
     * convert BO to Map
     *
     * @param bo
     * @return
     */
    private Map<String, String> convert2Map(BaseBO bo) {

        Map<String, String> params = new HashMap<String, String>(0);
        try {
            PropertyUtilsBean propertyUtilsBean = new PropertyUtilsBean();
            PropertyDescriptor[] descriptors = propertyUtilsBean.getPropertyDescriptors(bo);
            for (int i = 0; i < descriptors.length; i++) {
                String name = descriptors[i].getName();
                if (!"class".equals(name)) {
                    params.put(name, String.valueOf(propertyUtilsBean.getNestedProperty(bo, name)));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        //logger.debug("[convert BO to MAP]\n" + params);

        return params;
    }

    /**
     * set default value for white list
     *
     * @param paraMap
     */
    private void insertDefaultParameters(Map<String, String> paraMap) {

        // if currently under PRODUCT environment, all required parameters is required,skipping this step
        if (PayplusConfig.MODEL.equals("CUSTOMERS")) {
            return;
        }

        if (paraMap.containsKey("requestNo")) {
            String requestNo = paraMap.get("requestNo");

            if (PayplusUtil.isNull(requestNo))
                paraMap.put("requestNo", PayplusUtil.genRequestNo());
        }

        if (paraMap.containsKey("merchantNo")) {
            String merchantNo = paraMap.get("merchantNo");

            if (PayplusUtil.isNull(merchantNo))
                paraMap.put("merchantNo", PayplusConfig.MERCHANT_NO);
        }

        if (paraMap.containsKey("serverCallbackUrl")) {
            String requestNo = paraMap.get("serverCallbackUrl");

            if (PayplusUtil.isNull(requestNo))
                paraMap.put("serverCallbackUrl", PayplusConfig.GENERAL_URL);
        }

        if (paraMap.containsKey("webCallbackUrl")) {
            String requestNo = paraMap.get("webCallbackUrl");

            if (PayplusUtil.isNull(requestNo))
                paraMap.put("webCallbackUrl", PayplusConfig.GENERAL_URL);
        }

        // just for pwd verify
        if (paraMap.containsKey("webCallBackUrl")) {
            String requestNo = paraMap.get("webCallBackUrl");

            if (PayplusUtil.isNull(requestNo))
                paraMap.put("webCallBackUrl", PayplusConfig.GENERAL_URL);
        }

        if (paraMap.containsKey("returnUrl")) {
            String requestNo = paraMap.get("returnUrl");

            if (PayplusUtil.isNull(requestNo))
                paraMap.put("returnUrl", PayplusConfig.GENERAL_URL);
        }
    }

    private void setUpYOPRequest(YopRequest request, Map<String, String> paraMap) {

        insertDefaultParameters(paraMap);

        Set keys = paraMap.keySet();
        Iterator it = keys.iterator();

        while (it.hasNext()) {
            String key = (String) it.next();
            String value = paraMap.get(key);
            // hiding null value for format
            request.addParam(key, value == null || value == "null" ? "" : value);
        }
    }

    private void convert2Map(Field[] fields, Map paraMap, Class subBO, BaseBO bo) {
        for (Field f : fields) {
            String methodName = f.getName();
            String getter = "get" + methodName.substring(0, 1).toUpperCase() + methodName.substring(1);
            Object value = null;
            try {
                Method m = subBO.getMethod(getter, new Class[]{});
                value = m.invoke(bo, new Object[]{});
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }

            paraMap.put(methodName, String.valueOf(value));
        }
    }

}
