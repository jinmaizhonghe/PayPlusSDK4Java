package com.yeepay.payplus.bo;

/**
 * Created by Marco on 23/12/2016.
 */
public class MerchantRemitReq extends BaseBO{

    private String remiteInfos;
    private String serverCallbackUrl;
    private String trxRequestNo;

    public MerchantRemitReq() {
    }

    public String getServerCallbackUrl() {
        return serverCallbackUrl;
    }

    public void setServerCallbackUrl(String serverCallbackUrl) {
        this.serverCallbackUrl = serverCallbackUrl;
    }

    public String getTrxRequestNo() {
        return trxRequestNo;
    }

    public void setTrxRequestNo(String trxRequestNo) {
        this.trxRequestNo = trxRequestNo;
    }

    public MerchantRemitReq(String requestNo, String serverCallbackUrl, String remitInfos, String trxRequestNo){
        super.setRequestNo(requestNo);
        this.serverCallbackUrl = serverCallbackUrl;
        this.trxRequestNo = trxRequestNo;
        this.remiteInfos = remitInfos;
    }

    public String getRemiteInfos() {
        return remiteInfos;
    }

    public void setRemiteInfos(String remitInfos) {
        this.remiteInfos = remitInfos;
    }
}
