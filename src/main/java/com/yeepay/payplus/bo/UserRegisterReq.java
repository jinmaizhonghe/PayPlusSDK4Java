package com.yeepay.payplus.bo;

/**
 * Created by Marco on 15/12/2016.
 */
public class UserRegisterReq extends BaseBO{

    private String merchantNo;
    private String merchantUserId;

    public UserRegisterReq() {
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

    public UserRegisterReq(String requestNo, String merchantNo, String merchantUserId) {
        super.setRequestNo(requestNo);
        this.merchantNo = merchantNo;
        this.merchantUserId = merchantUserId;
    }

}
