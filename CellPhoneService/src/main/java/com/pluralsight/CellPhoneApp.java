package com.pluralsight;

public class CellPhoneApp {
    private int serialNumber;
    private String model;
    private String carrier;
    private String phoneNumber;
    private String owner;

    public CellPhoneApp(int serialNumber, String model, String carrier, String phoneNumber, String owner) {
        this.serialNumber = serialNumber;
        this.model = model;
        this.carrier = carrier;
        this.phoneNumber = phoneNumber;
        this.owner = owner;
    }

    public String toString() {
        return "What is your serial number? " + serialNumber +
                "What model is the phone? " + model +
                "Who is the carrier? " + carrier +
                "What is the phone number? " + phoneNumber  +
                "Who is the owner of the phone? " + owner ;
    }
}








