package com.yeepay.payplus.bo;

/**
 * Created by Marco on 23/12/2016.
 */
public class UserAuthReq extends BaseBO{

    private String merchantNo;
    private String merchantUserId;
    private String webCallbackUrl;
    private String returnUrl;

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

    public String getWebCallbackUrl() {
        return webCallbackUrl;
    }

    public void setWebCallbackUrl(String webCallbackUrl) {
        this.webCallbackUrl = webCallbackUrl;
    }

    public String getReturnUrl() {
        return returnUrl;
    }

    public void setReturnUrl(String returnUrl) {
        this.returnUrl = returnUrl;
    }

    private String clientSource;

    public String getClientSource() {
        return clientSource;
    }

    public void setClientSource(String clientSource) {
        this.clientSource = clientSource;
    }
}

