package com.pluralsight1.dealership_api.model;

public class Vehicle {
    private int vehicleId;
    private String vin;
    private String make;
    private String model;
    private int year;
    private String color;
    private String price;

    public Vehicle() {}

    public Vehicle(int vehicleId, String vin, String make, String model, int year, String color, String price) {
        this.vehicleId = vehicleId;
        this.vin = vin;
        this.make = make;
        this.model = model;
        this.year = year;
        this.color = color;
        this.price = price;
    }
    public int getVehicleId() { return vehicleId; }
    public void setVehicleId(int vehicleId) { this.vehicleId = vehicleId; }
    public String getVin() { return vin; }
    public void setVin(String vin) { this.vin = vin; }
    public String getMake() { return make; }
    public void setMake(String make) { this.make = make; }
    public String getModel() { return model; }
    public void setModel(String model) { this.model = model; }
    public int getYear() { return year; }
    public void setYear(int year) { this.year = year; }
    public String getColor() { return color; }
    public void setColor(String color) { this.color = color; }
    public String getPrice() { return price; }
    public void setPrice(String price) { this.price = price; }
}
