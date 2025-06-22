package com.pluralsight1.dealership_api.dao;

import com.pluralsight1.dealership_api.model.Dealership;

import java.util.List;

public interface DealershipDao {
    List<Dealership> getAll();
    Dealership getById(int id);
    Dealership insert(Dealership dealership);
    void update(int id, Dealership dealership);
    void delete(int id);
}
