package com.yeepay.payplus.bo;

/**
 * Created by Marco on 26/12/2016.
 */
public class LedgerUploadReq extends BaseBO {

    public static final String QUALIFICATIONTYPE_ID_CARD_FRONT = "ID_CARD_FRONT";
    public static final String QUALIFICATIONTYPE_ID_CARD_BACK = "ID_CARD_BACK";
    public static final String QUALIFICATIONTYPE_BANK_CARD_FRONT = "BANK_CARD_FRONT";
    public static final String QUALIFICATIONTYPE_BANK_CARD_BACK = "BANK_CARD_BACK";
    public static final String QUALIFICATIONTYPE_PERSON_PHOTO = "PERSON_PHOTO";
    public static final String QUALIFICATIONTYPE_BUSSINESS_LICENSE = "BUSSINESS_LICENSE";
    public static final String QUALIFICATIONTYPE_BUSSINESS_CERTIFICATES = "BUSSINESS_CERTIFICATES";
    public static final String QUALIFICATIONTYPE_BANK_ACCOUNT_LICENCE = "BANK_ACCOUNT_LICENCE";
    public static final String QUALIFICATIONTYPE_ORGANIZATION_CODE = "ORGANIZATION_CODE";

    private String merchantNo;
    private String ledgerNo;
    private String qualificationType;
    private String imgBase64Buffer;

    public LedgerUploadReq() {
    }

    public LedgerUploadReq(String merchantNo, String ledgerNo, String qualificationType, String imgBase64Buffer) {
        this.merchantNo = merchantNo;
        this.ledgerNo = ledgerNo;
        this.qualificationType = qualificationType;
        this.imgBase64Buffer = imgBase64Buffer;
    }

    public String getLedgerNo() {
        return ledgerNo;
    }

    public void setLedgerNo(String ledgerNo) {
        this.ledgerNo = ledgerNo;
    }

    public String getQualificationType() {
        return qualificationType;
    }

    public void setQualificationType(String qualificationType) {
        this.qualificationType = qualificationType;
    }

    public String getImgBase64Buffer() {
        return imgBase64Buffer;
    }

    public void setImgBase64Buffer(String imgBase64Buffer) {
        this.imgBase64Buffer = imgBase64Buffer;
    }
}
