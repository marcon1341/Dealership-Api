package com.pluralsight1.dealership_api.control;

import com.pluralsight1.dealership_api.dao.VehicleDao;
import com.pluralsight1.dealership_api.model.Vehicle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vehicles")
public class VehiclesController {
    private VehicleDao vehicleDao;

    @Autowired
    public VehiclesController(VehicleDao vehicleDao){
        this.vehicleDao=vehicleDao;
    }
    @GetMapping
    public List<Vehicle> getAllVehicles(){
        return vehicleDao.getAll();
    }
    @GetMapping("/search")
    public List<Vehicle> searchVehicles(
            @RequestParam(required = false) String make,
            @RequestParam(required = false) String model,
            @RequestParam(required = false) Integer minYear,
            @RequestParam(required = false) Integer maxYear,
            @RequestParam(required = false) String color,
            @RequestParam(required = false) String minPrice,
            @RequestParam(required = false) String maxPrice
    ) {
        if (make != null || model != null || minYear != null || maxYear != null || color != null || minPrice != null || maxPrice != null) {
            return vehicleDao.search(make, model, minYear, maxYear, color, minPrice, maxPrice);
        } else {
            return vehicleDao.getAll();
        }
    }
    @GetMapping("/{id}")
    public Vehicle getVehicleById(@PathVariable int id) {
        return vehicleDao.getById(id);
    }
    @PostMapping
    public Vehicle addVehicle(@RequestBody Vehicle vehicle){
        return vehicleDao.insert(vehicle);
    }
    @PutMapping("/{id}")
    public void updateVehicle(@PathVariable int id, @RequestBody Vehicle vehicle){
        vehicleDao.update(id, vehicle);
    }
    @DeleteMapping("/{id}")
    public void deleteVehicle(@PathVariable int id){
        vehicleDao.delete(id);
    }
}
