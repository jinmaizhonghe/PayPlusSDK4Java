package com.yeepay.payplus.bo;

/**
 * Created by Marco on 16/12/2016.
 */
public class MarketingRedPacketSendReq extends BaseBO{

    private String activeNo;
    private String merchantNo;
    private String merchantUserId;

    public MarketingRedPacketSendReq() {
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

    public MarketingRedPacketSendReq(String merchantNo, String merchantUserId, String activeNo) {
        this.merchantNo = merchantNo;
        this.merchantUserId = merchantUserId;

        this.activeNo = activeNo;
    }

    public String getActiveNo() {
        return activeNo;
    }

    public void setActiveNo(String activeNo) {
        this.activeNo = activeNo;
    }
}
