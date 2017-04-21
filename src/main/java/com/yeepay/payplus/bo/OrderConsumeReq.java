package com.yeepay.payplus.bo;

/**
 * Created by Marco on 16/12/2016.
 */
public class OrderConsumeReq extends BaseBO {

    private String merchantNo;
    private String merchantUserId;
    private String orderAmount;
    private String fundAmount;
    private String couponNos;
    private String payTool;
    private String bindCardId;
    private String merchantExpireTime;
    private String bankCode;
    private String merchantOrderDate;
    private String trxExtraInfo;

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

    private String serverCallbackUrl;
    private String webCallbackUrl;
    private String mcc;
    private String productCatalog;
    private String productName;
    private String productDesc;
    private String marketingExtraInfo;
    private String ip;
    private String openId;

    public String getOrderAmount() {
        return orderAmount;
    }

    public void setOrderAmount(String orderAmount) {
        this.orderAmount = orderAmount;
    }

    public String getFundAmount() {
        return fundAmount;
    }

    public void setFundAmount(String fundAmount) {
        this.fundAmount = fundAmount;
    }

    public String getCouponNos() {
        return couponNos;
    }

    public void setCouponNos(String couponNos) {
        this.couponNos = couponNos;
    }

    public String getPayTool() {
        return payTool;
    }

    public void setPayTool(String payTool) {
        this.payTool = payTool;
    }

    public String getBindCardId() {
        return bindCardId;
    }

    public void setBindCardId(String bindCardId) {
        this.bindCardId = bindCardId;
    }

    public String getMerchantExpireTime() {
        return merchantExpireTime;
    }

    public void setMerchantExpireTime(String merchantExpireTime) {
        this.merchantExpireTime = merchantExpireTime;
    }

    public String getBankCode() {
        return bankCode;
    }

    public void setBankCode(String bankCode) {
        this.bankCode = bankCode;
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

    public String getMcc() {
        return mcc;
    }

    public void setMcc(String mcc) {
        this.mcc = mcc;
    }

    public String getProductCatalog() {
        return productCatalog;
    }

    public void setProductCatalog(String productCatalog) {
        this.productCatalog = productCatalog;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductDesc() {
        return productDesc;
    }

    public void setProductDesc(String productDesc) {
        this.productDesc = productDesc;
    }

    public String getMarketingExtraInfo() {
        return marketingExtraInfo;
    }

    public void setMarketingExtraInfo(String marketingExtraInfo) {
        this.marketingExtraInfo = marketingExtraInfo;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }
}
