package com.yeepay.payplus.bo;

/**
 * Created by Marco on 10/01/2017.
 */
public class MerchantRechargeReq extends BaseBO {

    private String merchantNo;
    private String orderAmount;
    private String payTool;
    private String merchantExpireTime;
    private String merchantOrderDate;
    private String trxExtraInfo;
    private String bankCode;
    private String serverCallbackUrl;
    private String webCallbackUrl;

    public String getMerchantNo() {
        return merchantNo;
    }

    public void setMerchantNo(String merchantNo) {
        this.merchantNo = merchantNo;
    }

    public String getOrderAmount() {
        return orderAmount;
    }

    public void setOrderAmount(String orderAmount) {
        this.orderAmount = orderAmount;
    }

    public String getPayTool() {
        return payTool;
    }

    public void setPayTool(String payTool) {
        this.payTool = payTool;
    }

    public String getMerchantExpireTime() {
        return merchantExpireTime;
    }

    public void setMerchantExpireTime(String merchantExpireTime) {
        this.merchantExpireTime = merchantExpireTime;
    }

    public String getMerchantOrderDate() {
        return merchantOrderDate;
    }

    public void setMerchantOrderDate(String merchantOrderDate) {
        this.merchantOrderDate = merchantOrderDate;
    }

    public String getTrxExtraInfo() {
        return trxExtraInfo;
    }

    public void setTrxExtraInfo(String trxExtraInfo) {
        this.trxExtraInfo = trxExtraInfo;
    }

    public String getBankCode() {
        return bankCode;
    }

    public void setBankCode(String bankCode) {
        this.bankCode = bankCode;
    }

    public String getServerCallbackUrl() {
        return serverCallbackUrl;
    }

    public void setServerCallbackUrl(String serverCallbackUrl) {
        this.serverCallbackUrl = serverCallbackUrl;
    }

    public String getWebCallbackUrl() {
        return webCallbackUrl;
    }

    public void setWebCallbackUrl(String webCallbackUrl) {
        this.webCallbackUrl = webCallbackUrl;
    }
}
