package com.pluralsight1.dealership_api.control;

import com.pluralsight1.dealership_api.dao.InventoryDao;
import com.pluralsight1.dealership_api.model.Inventory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/inventory")
public class InventoryController {
    private final InventoryDao inventoryDao;

    @Autowired
    public InventoryController(InventoryDao inventoryDao) {
        this.inventoryDao = inventoryDao;
    }

    @GetMapping
    public List<Inventory> getAllInventory() {
        return inventoryDao.getAll();
    }

    @GetMapping("/{id}")
    public Inventory getInventoryById(@PathVariable int id) {
        return inventoryDao.getById(id);
    }

    @PostMapping
    public Inventory addInventory(@RequestBody Inventory inventory) {
        return inventoryDao.insert(inventory);
    }

    @PutMapping("/{id}")
    public void updateInventory(@PathVariable int id, @RequestBody Inventory inventory) {
        inventoryDao.update(id, inventory);
    }

    @DeleteMapping("/{id}")
    public void deleteInventory(@PathVariable int id) {
        inventoryDao.delete(id);
    }
}