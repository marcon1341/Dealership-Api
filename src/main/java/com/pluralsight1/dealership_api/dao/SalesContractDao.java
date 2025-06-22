package com.pluralsight1.dealership_api.dao;

import com.pluralsight1.dealership_api.model.SalesContract;

import java.util.List;

public interface SalesContractDao {
    List<SalesContract> getAll();
    SalesContract getById(int id);
    SalesContract insert(SalesContract salesContract);
    void update(int id, SalesContract salesContract);
    void delete(int id);
}

