package com.yeepay.payplus.bo;

/**
 * Created by Marco on 26/12/2016.
 */
public class LedgerRegisterReq extends BaseBO {

    public static final String CUSTOMERSTYLE_PERSON = "PERSON";
    public static final String CUSTOMERSTYLE_ENTERPRISE = "ENTERPRISE";

    public static final String BANKACCOUNTTYPE_PRIVATE_CASH="PRIVATE_CASH";
    public static final String BANKACCOUNTTYPE_PUBLIC_CASH="PUBLIC_CASH";

    private String merchantNo;
    private String province;
    private String city;
    private String customerStyle;
    private String businessLicence;
    private String signedName;
    private String idCard;
    private String legalPerson;
    private String contactor;
    private String bindMobile;
    private String email;
    private String bankAccountNumber;
    private String accountName;
    private String bankAccountType;
    private String bankName;
    private String bankCardProvince;
    private String bankCardCity;
    private String minSettleAmount;
    private String riskReserveDay;

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCustomerStyle() {
        return customerStyle;
    }

    public void setCustomerStyle(String customerStyle) {
        this.customerStyle = customerStyle;
    }

    public String getBusinessLicence() {
        return businessLicence;
    }

    public void setBusinessLicence(String businessLicence) {
        this.businessLicence = businessLicence;
    }

    public String getSignedName() {
        return signedName;
    }

    public void setSignedName(String signedName) {
        this.signedName = signedName;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getLegalPerson() {
        return legalPerson;
    }

    public void setLegalPerson(String legalPerson) {
        this.legalPerson = legalPerson;
    }

    public String getContactor() {
        return contactor;
    }

    public void setContactor(String contactor) {
        this.contactor = contactor;
    }

    public String getBindMobile() {
        return bindMobile;
    }

    public void setBindMobile(String bindMobile) {
        this.bindMobile = bindMobile;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getBankAccountNumber() {
        return bankAccountNumber;
    }

    public void setBankAccountNumber(String bankAccountNumber) {
        this.bankAccountNumber = bankAccountNumber;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public String getBankAccountType() {
        return bankAccountType;
    }

    public void setBankAccountType(String bankAccountType) {
        this.bankAccountType = bankAccountType;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getBankCardProvince() {
        return bankCardProvince;
    }

    public void setBankCardProvince(String bankCardProvince) {
        this.bankCardProvince = bankCardProvince;
    }

    public String getBankCardCity() {
        return bankCardCity;
    }

    public void setBankCardCity(String bankCardCity) {
        this.bankCardCity = bankCardCity;
    }

    public String getMinSettleAmount() {
        return minSettleAmount;
    }

    public void setMinSettleAmount(String minSettleAmount) {
        this.minSettleAmount = minSettleAmount;
    }

    public String getRiskReserveDay() {
        return riskReserveDay;
    }

    public String getMerchantNo() {
        return merchantNo;
    }

    public void setMerchantNo(String merchantNo) {
        this.merchantNo = merchantNo;
    }

    public void setRiskReserveDay(String riskReserveDay) {
        this.riskReserveDay = riskReserveDay;
    }
}
