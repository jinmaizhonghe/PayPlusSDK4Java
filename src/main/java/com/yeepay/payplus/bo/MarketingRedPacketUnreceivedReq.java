package com.yeepay.payplus.bo;

/**
 * Created by Marco on 22/12/2016.
 */
public class MarketingRedPacketUnreceivedReq extends BaseBO{

    private String activeNo;
    private String merchantNo;
    private String merchantUserId;

    public MarketingRedPacketUnreceivedReq() {
    }

    public MarketingRedPacketUnreceivedReq(String activeNo, String merchantNo, String merchantUserId) {
        this.merchantNo = merchantNo;
        this.merchantUserId = merchantUserId;
        this.activeNo = activeNo;
        //
    }

    public String getActiveNo() {
        return activeNo;
    }

    public void setActiveNo(String activeNo) {
        this.activeNo = activeNo;
    }
}
