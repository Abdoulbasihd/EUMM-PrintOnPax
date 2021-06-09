package com.example.printonpax.notifyer;

import java.io.Serializable;

public class AgResponse implements Serializable {

    private String reservationId;

    private String status, message, phone, amount, currency, fees, commission;
    private String referenceId, transactionId, transactionDate, biller, customerName;
    private String paymentStatus, dateLimit, acquirertrxref, bankName, senderLastname, senderFirstname;
    private String senderphone, senderidNumber, senderidType, senderBirthday, senderAddress;
    private String beneficiaryLastname, beneficiaryFirstname, beneficiaryphone, beneficiaryBirthday;
    private String beneficiaryidType, beneficiaryidNumber, beneficiaryAdress, beneficiaryCity;
    private String originatingCountry, originatingCurrency, updatime, destinationCountry, destinationCurrency;
    private String localAmount, payoutAmount, exchangeRate, customerCharge, bankAccount, access_token, token_type;
    private String refresh_token, expires_in, scope, issuertrtxref, intent, createtime, senderMobile;
    private String receiverMobile, description, tomember, state, voucherCode, expirytime, error, error_description;


    private String penalty, unpaid, minToPay, senderDatepiece, senderCardExpiration, senderPaysCard;

    private String question, answer;

    private String settlmentCurrency;
    private String settlmentAmount;

    private String lettre; //used for iMoney search... If 0, no code_s, else code_s

    public void setLettre(String lettre) {
        this.lettre = lettre;
    }

    public String getLettre() {
        return lettre;
    }

    public String getReservationId() {
        return reservationId;
    }

    public void setReservationId(String reservationId) {
        this.reservationId = reservationId;
    }

    public String getSettlmentCurrency() {
        return settlmentCurrency;
    }

    public void setSettlmentCurrency(String settlmentCurrency) {
        this.settlmentCurrency = settlmentCurrency;
    }

    public String getSettlmentAmount() {
        return settlmentAmount;
    }

    public void setSettlmentAmount(String settlmentAmount) {
        this.settlmentAmount = settlmentAmount;
    }

    public String getSenderMobile() {
        return senderMobile;
    }

    public void setSenderMobile(String senderMobile) {
        this.senderMobile = senderMobile;
    }

    public String getReceiverMobile() {
        return receiverMobile;
    }

    public void setReceiverMobile(String receiverMobile) {
        this.receiverMobile = receiverMobile;
    }

    public String getPenalty() {
        return penalty;
    }

    public void setPenalty(String penalty) {
        this.penalty = penalty;
    }

    public String getUnpaid() {
        return unpaid;
    }

    public void setUnpaid(String unpaid) {
        this.unpaid = unpaid;
    }

    public String getMinToPay() {
        return minToPay;
    }

    public void setMinToPay(String minToPay) {
        this.minToPay = minToPay;
    }

    public String getSenderDatepiece() {
        return senderDatepiece;
    }

    public void setSenderDatepiece(String senderDatepiece) {
        this.senderDatepiece = senderDatepiece;
    }

    public String getSenderCardExpiration() {
        return senderCardExpiration;
    }

    public void setSenderCardExpiration(String senderCardExpiration) {
        this.senderCardExpiration = senderCardExpiration;
    }

    public String getSenderPaysCard() {
        return senderPaysCard;
    }

    public void setSenderPaysCard(String senderPaysCard) {
        this.senderPaysCard = senderPaysCard;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    //For other Use Only
    private String  amount_to_be_collected;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getFees() {
        return fees;
    }

    public void setFees(String fees) {
        this.fees = fees;
    }

    public String getCommission() {
        return commission;
    }

    public void setCommission(String commission) {
        this.commission = commission;
    }

    public String getReferenceId() {
        return referenceId;
    }

    public void setReferenceId(String referenceId) {
        this.referenceId = referenceId;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public String getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(String transactionDate) {
        this.transactionDate = transactionDate;
    }

    public String getBiller() {
        return biller;
    }

    public void setBiller(String biller) {
        this.biller = biller;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(String paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public String getDateLimit() {
        return dateLimit;
    }

    public void setDateLimit(String dateLimit) {
        this.dateLimit = dateLimit;
    }

    public String getAmount_to_be_collected() {
        return amount_to_be_collected;
    }

    public void setAmount_to_be_collected(String amount_to_be_collected) {
        this.amount_to_be_collected = amount_to_be_collected;
    }

    public String getAcquirertrxref() {
        return acquirertrxref;
    }

    public void setAcquirertrxref(String acquirertrxref) {
        this.acquirertrxref = acquirertrxref;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getSenderLastname() {
        return senderLastname;
    }

    public void setSenderLastname(String senderLastname) {
        this.senderLastname = senderLastname;
    }

    public String getSenderFirstname() {
        return senderFirstname;
    }

    public void setSenderFirstname(String senderFirstname) {
        this.senderFirstname = senderFirstname;
    }

    public String getSenderphone() {
        return senderphone;
    }

    public void setSenderphone(String senderphone) {
        this.senderphone = senderphone;
    }

    public String getSenderidNumber() {
        return senderidNumber;
    }

    public void setSenderidNumber(String senderidNumber) {
        this.senderidNumber = senderidNumber;
    }

    public String getSenderidType() {
        return senderidType;
    }

    public void setSenderidType(String senderidType) {
        this.senderidType = senderidType;
    }

    public String getSenderBirthday() {
        return senderBirthday;
    }

    public void setSenderBirthday(String senderBirthday) {
        this.senderBirthday = senderBirthday;
    }

    public String getSenderAddress() {
        return senderAddress;
    }

    public void setSenderAddress(String senderAddress) {
        this.senderAddress = senderAddress;
    }

    public String getBeneficiaryLastname() {
        return beneficiaryLastname;
    }

    public void setBeneficiaryLastname(String beneficiaryLastname) {
        this.beneficiaryLastname = beneficiaryLastname;
    }

    public String getBeneficiaryFirstname() {
        return beneficiaryFirstname;
    }

    public void setBeneficiaryFirstname(String beneficiaryFirstname) {
        this.beneficiaryFirstname = beneficiaryFirstname;
    }

    public String getBeneficiaryphone() {
        return beneficiaryphone;
    }

    public void setBeneficiaryphone(String beneficiaryphone) {
        this.beneficiaryphone = beneficiaryphone;
    }

    public String getBeneficiaryBirthday() {
        return beneficiaryBirthday;
    }

    public void setBeneficiaryBirthday(String beneficiaryBirthday) {
        this.beneficiaryBirthday = beneficiaryBirthday;
    }

    public String getBeneficiaryidType() {
        return beneficiaryidType;
    }

    public void setBeneficiaryidType(String beneficiaryidType) {
        this.beneficiaryidType = beneficiaryidType;
    }

    public String getBeneficiaryidNumber() {
        return beneficiaryidNumber;
    }

    public void setBeneficiaryidNumber(String beneficiaryidNumber) {
        this.beneficiaryidNumber = beneficiaryidNumber;
    }

    public String getBeneficiaryAdress() {
        return beneficiaryAdress;
    }

    public void setBeneficiaryAdress(String beneficiaryAdress) {
        this.beneficiaryAdress = beneficiaryAdress;
    }

    public String getBeneficiaryCity() {
        return beneficiaryCity;
    }

    public void setBeneficiaryCity(String beneficiaryCity) {
        this.beneficiaryCity = beneficiaryCity;
    }

    public String getOriginatingCountry() {
        return originatingCountry;
    }

    public void setOriginatingCountry(String originatingCountry) {
        this.originatingCountry = originatingCountry;
    }

    public String getOriginatingCurrency() {
        return originatingCurrency;
    }

    public void setOriginatingCurrency(String originatingCurrency) {
        this.originatingCurrency = originatingCurrency;
    }

    public String getUpdatime() {
        return updatime;
    }

    public void setUpdatime(String updatime) {
        this.updatime = updatime;
    }

    public String getDestinationCountry() {
        return destinationCountry;
    }

    public void setDestinationCountry(String destinationCountry) {
        this.destinationCountry = destinationCountry;
    }

    public String getDestinationCurrency() {
        return destinationCurrency;
    }

    public void setDestinationCurrency(String destinationCurrency) {
        this.destinationCurrency = destinationCurrency;
    }

    public String getLocalAmount() {
        return localAmount;
    }

    public void setLocalAmount(String localAmount) {
        this.localAmount = localAmount;
    }

    public String getPayoutAmount() {
        return payoutAmount;
    }

    public void setPayoutAmount(String payoutAmount) {
        this.payoutAmount = payoutAmount;
    }

    public String getExchangeRate() {
        return exchangeRate;
    }

    public void setExchangeRate(String exchangeRate) {
        this.exchangeRate = exchangeRate;
    }

    public String getCustomerCharge() {
        return customerCharge;
    }

    public void setCustomerCharge(String customerCharge) {
        this.customerCharge = customerCharge;
    }

    public String getBankAccount() {
        return bankAccount;
    }

    public void setBankAccount(String bankAccount) {
        this.bankAccount = bankAccount;
    }

    public String getAccess_token() {
        return access_token;
    }

    public void setAccess_token(String access_token) {
        this.access_token = access_token;
    }

    public String getToken_type() {
        return token_type;
    }

    public void setToken_type(String token_type) {
        this.token_type = token_type;
    }

    public String getRefresh_token() {
        return refresh_token;
    }

    public void setRefresh_token(String refresh_token) {
        this.refresh_token = refresh_token;
    }

    public String getExpires_in() {
        return expires_in;
    }

    public void setExpires_in(String expires_in) {
        this.expires_in = expires_in;
    }

    public String getScope() {
        return scope;
    }

    public void setScope(String scope) {
        this.scope = scope;
    }

    public String getIssuertrtxref() {
        return issuertrtxref;
    }

    public void setIssuertrtxref(String issuertrtxref) {
        this.issuertrtxref = issuertrtxref;
    }

    public String getIntent() {
        return intent;
    }

    public void setIntent(String intent) {
        this.intent = intent;
    }

    public String getCreatetime() {
        return createtime;
    }

    public void setCreatetime(String createtime) {
        this.createtime = createtime;
    }

    public String getSendermobile() {
        return senderMobile;
    }

    public void setSendermobile(String sendermobile) {
        this.senderMobile = sendermobile;
    }

    public String getReceivermobile() {
        return receiverMobile;
    }

    public void setReceivermobile(String receivermobile) {
        this.receiverMobile = receivermobile;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTomember() {
        return tomember;
    }

    public void setTomember(String tomember) {
        this.tomember = tomember;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getVoucherCode() {
        return voucherCode;
    }

    public void setVoucherCode(String voucherCode) {
        this.voucherCode = voucherCode;
    }

    public String getExpirytime() {
        return expirytime;
    }

    public void setExpirytime(String expirytime) {
        this.expirytime = expirytime;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public String getError_description() {
        return error_description;
    }

    public void setError_description(String error_description) {
        this.error_description = error_description;
    }
}
