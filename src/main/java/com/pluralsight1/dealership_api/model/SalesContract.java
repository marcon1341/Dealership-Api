package com.pluralsight1.dealership_api.model;

public class SalesContract {
    private int salesContractsId;
    private String customerName;
    private int dealershipId;
    private int vehicleId;
    private String when;
    private String totalPrice;
    private String monthlyPayment;

    public SalesContract() {}

    public SalesContract(int salesContractsId, String customerName, int dealershipId, int vehicleId, String when, String totalPrice, String monthlyPayment) {
        this.salesContractsId = salesContractsId;
        this.customerName = customerName;
        this.dealershipId = dealershipId;
        this.vehicleId = vehicleId;
        this.when = when;
        this.totalPrice = totalPrice;
        this.monthlyPayment = monthlyPayment;
    }

    public int getSalesContractsId() { return salesContractsId; }
    public void setSalesContractsId(int salesContractsId) { this.salesContractsId = salesContractsId; }

    public String getCustomerName() { return customerName; }
    public void setCustomerName(String customerName) { this.customerName = customerName; }

    public int getDealershipId() { return dealershipId; }
    public void setDealershipId(int dealershipId) { this.dealershipId = dealershipId; }

    public int getVehicleId() { return vehicleId; }
    public void setVehicleId(int vehicleId) { this.vehicleId = vehicleId; }

    public String getWhen() { return when; }
    public void setWhen(String when) { this.when = when; }

    public String getTotalPrice() { return totalPrice; }
    public void setTotalPrice(String totalPrice) { this.totalPrice = totalPrice; }

    public String getMonthlyPayment() { return monthlyPayment; }
    public void setMonthlyPayment(String monthlyPayment) { this.monthlyPayment = monthlyPayment; }
}
