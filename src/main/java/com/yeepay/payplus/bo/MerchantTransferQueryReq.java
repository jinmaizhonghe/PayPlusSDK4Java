package com.yeepay.payplus.bo;

/**
 * Created by Marco on 06/01/2017.
 */
public class MerchantTransferQueryReq extends BaseBO{

    private String merchantNo;
    private String transferRequestNo;

    public MerchantTransferQueryReq(String merchantNo, String transferRequestNo) {
        this.merchantNo = merchantNo;
        this.transferRequestNo = transferRequestNo;
    }

    public String getMerchantNo() {
        return merchantNo;
    }

    public void setMerchantNo(String merchantNo) {
        this.merchantNo = merchantNo;
    }

    public String getTransferRequestNo() {
        return transferRequestNo;
    }

    public void setTransferRequestNo(String transferRequestNo) {
        this.transferRequestNo = transferRequestNo;
    }
}
