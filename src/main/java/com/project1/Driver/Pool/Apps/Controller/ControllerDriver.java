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

import com.project1.Driver.Pool.Apps.Entity.Driver;
import com.project1.Driver.Pool.Apps.Service.DriverService;

@Controller
@RestController
@RequestMapping("/api/drivers")
public class ControllerDriver {
    @Autowired
    private DriverService driverService;

    // Get all transaction
    @GetMapping
    public List<Driver> getAllDrivers() {
        return driverService.getAllDrivers();
    }

    // Get driver by ID
    @GetMapping("/{id}")
    public Optional<Driver> getDriverById(@PathVariable int id) {
        return driverService.getDriverById(id);
    }

    // Create a new driver
    @PostMapping
    public Driver createDriver(@RequestBody Driver driver) {
        return driverService.saveDriver(driver);
    }

    // Update an existing driver
    @PutMapping("/{id}")
    public Driver updateDriver(@PathVariable int id, @RequestBody Driver driver) {
        driver.setId(id);
        return driverService.saveDriver(driver);
    }

    // Delete a driver by ID
    @DeleteMapping("/{id}")
    public void deleteDriver(@PathVariable int id) {
        driverService.deleteDriver(id);
    }
}