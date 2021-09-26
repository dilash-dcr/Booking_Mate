package com.example.travelpartner;

public class Bookings {


    private String bid;
    private String name;
    private String uid;
    private String advertistmentID;
    private String address;
    private String starstingPoint;
    private String endPoint;
    private int noOfPassengers;
    private int noofDays;
    private int contactNo;

    public Bookings() {

    }

    public String getBid() { return bid;  }

    public void setBid(String bid) {this.bid = bid;}

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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getStarstingPoint() {
        return starstingPoint;
    }

    public void setStarstingPoint(String starstingPoint) {
        this.starstingPoint = starstingPoint;
    }

    public String getEndPoint() {
        return endPoint;
    }

    public void setEndPoint(String endPoint) {
        this.endPoint = endPoint;
    }

    public int getNoOfPassengers() {
        return noOfPassengers;
    }

    public void setNoOfPassengers(int noOfPassengers) {
        this.noOfPassengers = noOfPassengers;
    }

    public int getNoofDays() {
        return noofDays;
    }

    public void setNoofDays(int noofDays) {
        this.noofDays = noofDays;
    }

    public int getContactNo() {
        return contactNo;
    }

    public void setContactNo(int contactNo) {
        this.contactNo = contactNo;
    }

    public String getAdvertistmentID() {return advertistmentID;}

    public void setAdvertistmentID(String advertistmentID) {this.advertistmentID = advertistmentID;}
}
