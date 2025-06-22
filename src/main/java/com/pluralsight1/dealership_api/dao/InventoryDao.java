package com.pluralsight1.dealership_api.dao;

import com.pluralsight1.dealership_api.model.Inventory;

import java.util.List;

public interface InventoryDao {
    List<Inventory> getAll();
    Inventory getById(int id);
    Inventory insert(Inventory inventory);
    void update(int id, Inventory inventory);
    void delete(int id);
}

