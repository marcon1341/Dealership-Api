package com.pluralsight1.dealership_api.model;

public class Inventory {
    private int inventoryId;
    private int dealershipId;
    private int vehicleId;

    public Inventory() {}

    public Inventory(int inventoryId, int dealershipId, int vehicleId) {
        this.inventoryId = inventoryId;
        this.dealershipId = dealershipId;
        this.vehicleId = vehicleId;
    }

    public int getInventoryId() {
        return inventoryId;
    }

    public void setInventoryId(int inventoryId) {
        this.inventoryId = inventoryId;
    }

    public int getDealershipId() {
        return dealershipId;
    }

    public void setDealershipId(int dealershipId) {
        this.dealershipId = dealershipId;
    }

    public int getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(int vehicleId) {
        this.vehicleId = vehicleId;
    }
}

