package com.example.travelpartner;

public class Requests {

    String Name;
    String ADID;
    String RequesterUserName;
    String YourUserName;
    String contactNumber;
    String MeetingPoint;

    public Requests() {

    }

    public String getAdID() {
        return ADID;
    }

    public void setAdID(String adID) {
        this.ADID = adID;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getRequesterUserName() {
        return RequesterUserName;
    }

    public void setRequesterUserName(String requesterUserName) {
        RequesterUserName = requesterUserName;
    }

    public String getYourUserName() {
        return YourUserName;
    }

    public void setYourUserName(String yourUserName) {
        YourUserName = yourUserName;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public String getMeetingPoint() {
        return MeetingPoint;
    }

    public void setMeetingPoint(String meetingPoint) {
        MeetingPoint = meetingPoint;
    }
}
