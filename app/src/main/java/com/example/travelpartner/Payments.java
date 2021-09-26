package com.example.travelpartner;

public class Payments {

    private String name;
    private String uid;
    private String bid;
    private double amount;
    private String cnumber;
    private String owoname;
    private String exp;
    private int csv;
    private int referenceNumber;
    private String paymentid;

    public Payments(){

    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getBid() {
        return bid;
    }

    public void setBid(String bid) {
        this.bid = bid;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getCnumber() {
        return cnumber;
    }

    public void setCnumber(String cnumber) {
        this.cnumber = cnumber;
    }

    public String getOwoname() {
        return owoname;
    }

    public void setOwoname(String owoname) {
        this.owoname = owoname;
    }

    public String getExp() {
        return exp;
    }

    public void setExp(String exp) {
        this.exp = exp;
    }

    public int getCsv() {
        return csv;
    }

    public void setCsv(int csv) {
        this.csv = csv;
    }

    public int getReferenceNumber() { return referenceNumber;}

    public void setReferenceNumber(int referenceNumber) {this.referenceNumber = referenceNumber;}

    public String getPaymentid() { return paymentid;
    }

    public void setPaymentid(String paymentid) {
        this.paymentid = paymentid;
    }
}
