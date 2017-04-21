package com.yeepay.payplus.util;

import com.yeepay.payplus.exception.PayplusConfigException;

import java.io.*;
import java.util.MissingResourceException;
import java.util.PropertyResourceBundle;
import java.util.ResourceBundle;

/**
 * Created by Marco on 15/12/2016.
 */
public class PayplusConfig {

    public static final String DATE_FORMAT = "yyyy-MM-dd HH:mm:ss";

    public static final String GENERAL_URL = "http://payplus.yeepay.com";

    /**
     * 测试用户-1
     */
    public static final String JOEY_TRIBBIANI = "Joey";
    /**
     * 测试用户-2
     */
    public static final String MONICA_GELLER = "Monica";
    /**
     * 测试用户-3
     */
    public static final String PHOEBE_BUFFAY = "Phoebe";
    /**
     * 测试用户-4
     */
    public static final String ROSS_GELLER = "Ross";
    /**
     * 测试用户-5
     */
    public static final String CHANDLER_BING = "Chandler";
    /**
     * 测试用户-6
     */
    public static final String RACHEL_GREEN = "Rachel";

    /**
     * 测试用户-7
     */
    public static final String YANGYANG1 = "yangyang1";

    /**
     * appKey
     */
    public static String APP_KEY;
    /**
     * appSecret
     */
    public static String APP_SECRET;
    /**
     * 加密算法
     */
    public static String SIGN_ALGORITHM;
    /**
     * 调用地址
     */
    public static String ADDRESS;

    /**
     * 测试merchantNo
     */
    public static String MERCHANT_NO;

    public static String MODEL;

    public static String MODEL_CUSTOMERS;

    private static ResourceBundle getResourceOBJ() {

        ResourceBundle payplusConfig = null;

        try {
            payplusConfig = ResourceBundle.getBundle("payplus");
        } catch (MissingResourceException mre) {
            throw new PayplusConfigException("PLEASE SET UP A \"payplus.properties\" FOR USING THIS UTILITY.");
        }
        return payplusConfig;
    }

    private static ResourceBundle getResourceOBJ(String path) {
        //loading customers' configuration
        ResourceBundle payplusConfig = null;

        try {
            InputStream in = new BufferedInputStream(new FileInputStream(path));
            payplusConfig = new PropertyResourceBundle(in);
        } catch (FileNotFoundException e) {
            throw new PayplusConfigException("CANNOT FIND A \"PAYPLUS.PROPERTIES\" THROUGH CHECK THE PATH PROVIDED.");
        } catch (IOException e) {
            e.printStackTrace();
        }

        return payplusConfig;
    }

    private static void acquireCustomersConfig(ResourceBundle payplusConfig) {

        MODEL_CUSTOMERS = payplusConfig.getString("MODEL");

        // using default configuration if MODEL_CUSTOMERS's value equals "TEST"
        if (MODEL_CUSTOMERS.equals("TEST")) {
            return;

        } else if (MODEL_CUSTOMERS.equals("PRODUCTION")) {

            try {
                APP_KEY = payplusConfig.getString("APP_KEY");
                APP_SECRET = payplusConfig.getString("APP_SECRET");
            } catch (MissingResourceException mre) {
                throw new PayplusConfigException("1 - Please set up APP_KEY and APP_SECRET in payplus.properties.");
            }

            if (PayplusUtil.isNull(APP_KEY) || PayplusUtil.isNull(APP_SECRET)) {
                throw new PayplusConfigException("2 - Please set up APP_KEY and APP_SECRET in payplus.properties.");
            }
            MERCHANT_NO = APP_KEY;
        }
    }

    private static void loadDefaultConfig() {

        ResourceBundle rb = ResourceBundle.getBundle("cfg");

        // using default value for test environment corresponding with 'SELF' value of model
        MODEL = rb.getString("MODEL");
        ADDRESS = rb.getString("ADDRESS");
        APP_KEY = rb.getString("APP_KEY");
        APP_SECRET = rb.getString("APP_SECRET");
        MERCHANT_NO = rb.getString("MERCHANT_NO");
        SIGN_ALGORITHM = rb.getString("SIGN_ALGORITHM");
    }


    public static void init(String path) {

        loadDefaultConfig();

        if (MODEL.equals("CUSTOMERS")) {

            if (PayplusUtil.isNull(path))
                acquireCustomersConfig(getResourceOBJ());
            else
                acquireCustomersConfig(getResourceOBJ(path));
        }
    }

}
