package com.pluralsight1.dealership_api.control;

import com.pluralsight1.dealership_api.dao.DealershipDao;
import com.pluralsight1.dealership_api.model.Dealership;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/dealerships")
public class DealershipController {
    private DealershipDao dealershipDao;

    @Autowired
    public void DealershipsController(DealershipDao dealershipDao) {
        this.dealershipDao = dealershipDao;
    }

    @GetMapping
    public List<Dealership> getAllDealerships() {
        return dealershipDao.getAll();
    }

    @GetMapping("/{id}")
    public Dealership getDealershipById(@PathVariable int id) {
        return dealershipDao.getById(id);
    }

    @PostMapping
    public Dealership addDealership(@RequestBody Dealership dealership) {
        return dealershipDao.insert(dealership);
    }

    @PutMapping("/{id}")
    public void updateDealership(@PathVariable int id, @RequestBody Dealership dealership) {
        dealershipDao.update(id, dealership);
    }

    @DeleteMapping("/{id}")
    public void deleteDealership(@PathVariable int id) {
        dealershipDao.delete(id);
    }
}

