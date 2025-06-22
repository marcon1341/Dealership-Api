package com.pluralsight1.dealership_api.dao;

import com.pluralsight1.dealership_api.model.LeaseContract;

import java.util.List;

public interface LeaseContractDao {
    List<LeaseContract> getAll();
    LeaseContract getById(int id);
    LeaseContract insert(LeaseContract contract);
    void update(int id, LeaseContract contract);
    void delete(int id);
}
