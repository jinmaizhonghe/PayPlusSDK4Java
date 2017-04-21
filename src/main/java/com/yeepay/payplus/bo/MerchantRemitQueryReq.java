package com.yeepay.payplus.bo;

/**
 * Created by Marco on 23/12/2016.
 */
public class MerchantRemitQueryReq extends BaseBO {

    /**
     * return all remits in such trxRequestNo order, if this variable is null
     */
    private String remiteRequestNo;
    private String merchantNo;
    private String trxRequestNo;

    public MerchantRemitQueryReq() {
    }

    public String getMerchantNo() {
        return merchantNo;
    }

    public void setMerchantNo(String merchantNo) {
        this.merchantNo = merchantNo;
    }

    public String getTrxRequestNo() {
        return trxRequestNo;
    }

    public void setTrxRequestNo(String trxRequestNo) {
        this.trxRequestNo = trxRequestNo;
    }

    public MerchantRemitQueryReq(String merchantNo, String trxRequestNo, String remiteRequestNo) {
        this.merchantNo = merchantNo;
        this.trxRequestNo = trxRequestNo;

        this.remiteRequestNo = remiteRequestNo;
    }

    public String getRemiteRequestNo() {
        return remiteRequestNo;
    }

    public void setRemiteRequestNo(String remiteRequestNo) {
        this.remiteRequestNo = remiteRequestNo;
    }
}
