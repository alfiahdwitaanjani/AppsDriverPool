package com.project1.Driver.Pool.Apps.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project1.Driver.Pool.Apps.Entity.Car;
import com.project1.Driver.Pool.Apps.Service.CarService;

@Controller
@RestController
@RequestMapping("/api/cars")
public class ControllerCar {
    @Autowired
    private CarService carService;

    // Get all transaction
    @GetMapping
    public List<Car> getAllCars() {
        return carService.getAllCars();
    }

    // Get driver by ID
    @GetMapping("/{id}")
    public Optional<Car> getCarById(@PathVariable int id) {
        return carService.getCarById(id);
    }

    // Create a new driver
    @PostMapping
    public Car createCar(@RequestBody Car car) {
        return carService.saveCar(car);
    }

    // Update an existing driver
    @PutMapping("/{id}")
    public Car updateCar(@PathVariable int id, @RequestBody Car car) {
        car.setId(id);
        return carService.saveCar(car);
    }

    // Delete a driver by ID
    @DeleteMapping("/{id}")
    public void deleteCar(@PathVariable int id) {
        carService.deleteCar(id);
    }
}