package com.pluralsight1.dealership_api.dao;

import com.pluralsight1.dealership_api.model.Vehicle;

import java.util.List;

public interface VehicleDao {
    List<Vehicle> getAll();
    Vehicle getById(int id);
    Vehicle insert(Vehicle vehicle);
    void update(int id, Vehicle vehicle);
    void delete(int id);

    List<Vehicle> search(String make, String model, Integer minYear, Integer maxYear, String color, String minPrice, String maxPrice);
}

