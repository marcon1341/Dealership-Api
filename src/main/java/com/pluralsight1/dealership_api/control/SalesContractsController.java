package com.pluralsight1.dealership_api.control;

import com.pluralsight1.dealership_api.dao.SalesContractDao;
import com.pluralsight1.dealership_api.model.SalesContract;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sales-contracts")
public class SalesContractsController {
    private final SalesContractDao salesContractDao;

    @Autowired
    public SalesContractsController(SalesContractDao salesContractDao) {
        this.salesContractDao = salesContractDao;
    }

    @GetMapping
    public List<SalesContract> getAllContracts() {
        return salesContractDao.getAll();
    }

    @GetMapping("/{id}")
    public SalesContract getContractById(@PathVariable int id) {
        return salesContractDao.getById(id);
    }

    @PostMapping
    public SalesContract addContract(@RequestBody SalesContract contract) {
        return salesContractDao.insert(contract);
    }

    @PutMapping("/{id}")
    public void updateContract(@PathVariable int id, @RequestBody SalesContract contract) {
        salesContractDao.update(id, contract);
    }

    @DeleteMapping("/{id}")
    public void deleteContract(@PathVariable int id) {
        salesContractDao.delete(id);
    }
}
