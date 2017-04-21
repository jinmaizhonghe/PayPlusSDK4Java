package com.yeepay.payplus.bo;

/**
 * Created by Marco on 21/12/2016.
 */
public class UserVerifyPWDReq extends BaseBO {

    public static final String TOKENBIZTYPE_TRANSFER = "TRANSFER";
    public static final String TOKENBIZTYPE_WITHDRAW = "WITHDRAW";
    public static final String TOKENBIZTYPE_UN_BIND_CARD = "UN_BIND_CARD";

    private String merchantNo;
    private String merchantUserId;
    private String webCallBackUrl;
    private String tokenBizType;
    private String returnUrl;
    private String clientSource;

    public String getTokenBizType() {
        return tokenBizType;
    }

    public void setTokenBizType(String tokenBizType) {
        this.tokenBizType = tokenBizType;
    }

    public String getMerchantNo() {
        return merchantNo;
    }

    public void setMerchantNo(String merchantNo) {
        this.merchantNo = merchantNo;
    }

    public String getMerchantUserId() {
        return merchantUserId;
    }

    public void setMerchantUserId(String merchantUserId) {
        this.merchantUserId = merchantUserId;
    }

    public String getWebCallBackUrl() {
        return webCallBackUrl;
    }

    public void setWebCallBackUrl(String webCallBackUrl) {
        this.webCallBackUrl = webCallBackUrl;
    }

    public String getReturnUrl() {
        return returnUrl;
    }

    public void setReturnUrl(String returnUrl) {
        this.returnUrl = returnUrl;
    }

    public String getClientSource() {
        return clientSource;
    }

    public void setClientSource(String clientSource) {
        this.clientSource = clientSource;
    }
}
