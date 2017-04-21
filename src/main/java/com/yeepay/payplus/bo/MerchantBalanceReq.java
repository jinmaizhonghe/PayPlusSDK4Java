package com.yeepay.payplus.bo;

/**
 * Created by Marco on 10/01/2017.
 */
public class MerchantBalanceReq extends BaseBO{

    private String merchantNo;

    public MerchantBalanceReq() {
    }

    public MerchantBalanceReq(String merchantNo) {
        this.merchantNo = merchantNo;
    }

    public String getMerchantNo() {
        return merchantNo;
    }

    public void setMerchantNo(String merchantNo) {
        this.merchantNo = merchantNo;
    }
}
