package com.project1.Driver.Pool.Apps.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project1.Driver.Pool.Apps.Entity.Driver;
import com.project1.Driver.Pool.Apps.Entity.Log;
import com.project1.Driver.Pool.Apps.Repository.DriverRepository;
import com.project1.Driver.Pool.Apps.Repository.LogRepository;

@Service
public class DriverService {
    @Autowired
    private DriverRepository driverRepository;

    @Autowired
    private LogRepository logRepository;

    // Find all drivers
    public List<Driver> getAllDrivers() {
        return driverRepository.findAll();
    }

    // Find a driver by ID
    public Optional<Driver> getDriverById(int id) {
        return driverRepository.findById(id);
    }

    // Create a new driver
    public Driver saveDriver(Driver driver) {
        Driver savedDriver = driverRepository.save(driver);
        logActivity("Created Driver", savedDriver);
        return savedDriver;
    }

    // Delete a driver by its ID
    public void deleteDriver(int id) {
        Optional<Driver> driverToDelete = driverRepository.findById(id);
        if (driverToDelete.isPresent()) {
            driverRepository.deleteById(id);
            logActivity("Deleted Driver", driverToDelete.get());
        } else {
            logActivity("Delete Failed (Driver Not Found)", null);
        }
    }

    // Log the action performed on a driver entity
    private void logActivity(String action, Driver driver) {
        Log log = new Log();
        String logMessage = "{\"action\": \"" + action + "\"";

        if (driver != null) {
            logMessage += ", \"driverID\": \"" + driver.getId() + "\"";
            logMessage += ", \"driverName\": \"" + driver.getName() + "\"";
            logMessage += ", \"no_wa\": \"" + driver.getNo_wa() + "\"";
        }

        logMessage += "}";

        log.setLog(logMessage);
        logRepository.save(log);
    }
}