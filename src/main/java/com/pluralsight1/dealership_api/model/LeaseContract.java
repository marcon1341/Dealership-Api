package com.pluralsight1.dealership_api.model;

import java.math.BigDecimal;
import java.sql.Timestamp;

public class LeaseContract {
    private int leaseContractsId;
    private String customerName;
    private int dealershipId;
    private int vehicleId;
    private Timestamp when;
    private BigDecimal totalPrice;
    private BigDecimal monthlyPayment;

    public LeaseContract(int leaseContractsId, String customerName, int dealershipId, int vehicleId,
                         Timestamp when, BigDecimal totalPrice, BigDecimal monthlyPayment) {
        this.leaseContractsId = leaseContractsId;
        this.customerName = customerName;
        this.dealershipId = dealershipId;
        this.vehicleId = vehicleId;
        this.when = when;
        this.totalPrice = totalPrice;
        this.monthlyPayment = monthlyPayment;
    }

    public int getLeaseContractsId() { return leaseContractsId; }
    public void setLeaseContractsId(int leaseContractsId) { this.leaseContractsId = leaseContractsId; }

    public String getCustomerName() { return customerName; }
    public void setCustomerName(String customerName) { this.customerName = customerName; }

    public int getDealershipId() { return dealershipId; }
    public void setDealershipId(int dealershipId) { this.dealershipId = dealershipId; }

    public int getVehicleId() { return vehicleId; }
    public void setVehicleId(int vehicleId) { this.vehicleId = vehicleId; }

    public Timestamp getWhen() { return when; }
    public void setWhen(Timestamp when) { this.when = when; }

    public BigDecimal getTotalPrice() { return totalPrice; }
    public void setTotalPrice(BigDecimal totalPrice) { this.totalPrice = totalPrice; }

    public BigDecimal getMonthlyPayment() { return monthlyPayment; }
    public void setMonthlyPayment(BigDecimal monthlyPayment) { this.monthlyPayment = monthlyPayment; }
}
