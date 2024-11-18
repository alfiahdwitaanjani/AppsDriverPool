package com.project1.Driver.Pool.Apps.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project1.Driver.Pool.Apps.Entity.Car;
import com.project1.Driver.Pool.Apps.Entity.Log;
import com.project1.Driver.Pool.Apps.Repository.CarRepository;
import com.project1.Driver.Pool.Apps.Repository.LogRepository;

@Service
public class CarService {
    @Autowired
    private CarRepository carRepository;

    @Autowired
    private LogRepository logRepository;

    public List<Car> getAllCars() {
        return carRepository.findAll();
    }

    public Optional<Car> getCarById(int id) {
        return carRepository.findById(id);
    }

    public Car saveCar(Car car) {
        Car savedCar = carRepository.save(car);
        logActivity("Created Car", savedCar);
        return savedCar;
    }

    public Car updateCar(int id, Car car) {
        car.setId(id);
        Car updatedCar = carRepository.save(car);
        logActivity("Updated Car", updatedCar);
        return updatedCar;
    }

    public void deleteCar(int id) {
        carRepository.deleteById(id);
        logActivity("Deleted Car", null);
    }

    private void logActivity(String action, Car car) {
        Log log = new Log();
        log.setLog("{\"action\": \"" + action + "\", \"carID\": \"" + (car != null ? car.getId() : "") + "\"}");
        logRepository.save(log);
    }
}