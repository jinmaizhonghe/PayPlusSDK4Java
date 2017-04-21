package com.yeepay.payplus.bo;

/**
 * Created by Marco on 22/12/2016.
 */
public class MarketingRedPacketReceiveReq extends BaseBO {

    private String marketNo;
    private String merchantNo;
    private String merchantUserId;

    public MarketingRedPacketReceiveReq() {
    }

    public MarketingRedPacketReceiveReq(String marketNo, String merchantNo, String merchantUserId) {
        this.marketNo = marketNo;
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

    public String getMarketNo() {
        return marketNo;
    }

    public void setMarketNo(String marketNo) {
        this.marketNo = marketNo;
    }
}
