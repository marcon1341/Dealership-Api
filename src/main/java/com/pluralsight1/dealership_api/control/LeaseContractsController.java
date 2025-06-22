package com.pluralsight1.dealership_api.control;

import com.pluralsight1.dealership_api.dao.LeaseContractDao;
import com.pluralsight1.dealership_api.model.LeaseContract;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/lease-contracts")
public class LeaseContractsController {
    private LeaseContractDao leaseContractDao;

    @Autowired
    public LeaseContractsController(LeaseContractDao leaseContractDao) {
        this.leaseContractDao = leaseContractDao;
    }

    // GET all lease contracts
    @GetMapping
    public List<LeaseContract> getAll() {
        return leaseContractDao.getAll();
    }

    // GET lease contract by ID
    @GetMapping("/{id}")
    public LeaseContract getById(@PathVariable int id) {
        return leaseContractDao.getById(id);
    }

    // POST a new lease contract
    @PostMapping
    public LeaseContract add(@RequestBody LeaseContract contract) {
        return leaseContractDao.insert(contract);
    }

    // PUT update lease contract
    @PutMapping("/{id}")
    public void update(@PathVariable int id, @RequestBody LeaseContract contract) {
        leaseContractDao.update(id, contract);
    }

    // DELETE lease contract by ID
    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        leaseContractDao.delete(id);
    }
}
