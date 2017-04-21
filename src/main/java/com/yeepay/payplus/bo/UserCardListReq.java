package com.yeepay.payplus.bo;

/**
 * Created by Marco on 05/01/2017.
 */
public class UserCardListReq extends BaseBO {

    private String merchantNo;
    private String merchantUserId;

    public UserCardListReq(String merchantNo, String merchantUserId) {
        this.merchantNo = merchantNo;
        this.merchantUserId = merchantUserId;
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
}
