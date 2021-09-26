package com.example.travelpartner;

public class RentVehicle {

    private String rid;
    private String Id;
    private String VehicleType;
    private String VehicleModel;
    private String AvailableSeats;
    private String VehiclePrice;
    private String Contact;
    private String Description;

    public RentVehicle() {
    }

    public String getRid() {
        return rid;
    }

    public void setRid(String rid) {
        this.rid = rid;
    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getVehicleType() {
        return VehicleType;
    }

    public void setVehicleType(String vehicleType) {
        VehicleType = vehicleType;
    }

    public String getVehicleModel() {
        return VehicleModel;
    }

    public void setVehicleModel(String vehicleModel) {
        VehicleModel = vehicleModel;
    }

    public String getAvailableSeats() {
        return AvailableSeats;
    }

    public void setAvailableSeats(String availableSeats) {
        AvailableSeats = availableSeats;
    }

    public String getVehiclePrice() {
        return VehiclePrice;
    }

    public void setVehiclePrice(String vehiclePrice) {
        VehiclePrice = vehiclePrice;
    }

    public String getContact() {
        return Contact;
    }

    public void setContact(String contact) {
        Contact = contact;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }
}
