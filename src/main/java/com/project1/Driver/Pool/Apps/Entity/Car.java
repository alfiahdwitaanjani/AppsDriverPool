package com.project1.Driver.Pool.Apps.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String car;
    private int capacity;
    private String noplat;

    public Car() {
    }

    // Constructor with parameters (useful for easier instantiation)
    public Car(int id, String car, int capacity, String noplat) {
        this.id = id;
        this.car = car;
        this.capacity = capacity;
        this.noplat = noplat;
    }

    // Getters and setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCar() {
        return car;
    }

    public void setCar(String car) {
        this.car = car;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public String getNoplat() {
        return noplat;
    }

    public void setNoplat(String noplat) {
        this.noplat = noplat;
    }

    // Override toString() for better logging/debugging
    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", car='" + car + '\'' +
                ", capacity=" + capacity +
                ", noplat='" + noplat + '\'' +
                '}';
    }
}