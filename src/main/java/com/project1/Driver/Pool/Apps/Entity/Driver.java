package com.project1.Driver.Pool.Apps.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Driver {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;
    private String no_wa; // Assuming this is the driver's WhatsApp number or phone number

    // Default constructor
    public Driver() {
    }

    // Constructor with parameters (useful for easier instantiation)
    public Driver(int id, String name, String no_wa) {
        this.id = id;
        this.name = name;
        this.no_wa = no_wa;
    }

    // Getters and setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNo_wa() {
        return no_wa;
    }

    public void setNo_wa(String no_wa) {
        this.no_wa = no_wa;
    }

    // Override toString() method for better logging/debugging
    @Override
    public String toString() {
        return "Driver{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", no_wa='" + no_wa + '\'' +
                '}';
    }
}