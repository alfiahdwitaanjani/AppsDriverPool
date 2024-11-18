package com.project1.Driver.Pool.Apps.Entity;

import java.sql.Timestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "carID", referencedColumnName = "id", insertable = true, updatable = true)
    private Car car;

    @ManyToOne
    @JoinColumn(name = "driverID", referencedColumnName = "id", insertable = true, updatable = true)
    private Driver driver;

    @PrePersist
    public void prePersist() {
        createdAt = new Timestamp(System.currentTimeMillis());
    }

    @PreUpdate
    public void preUpdate() {
        updatedAt = new Timestamp(System.currentTimeMillis());
    }

    private String location;

    @Column(nullable = false, updatable = false)
    private Timestamp createdAt;

    private Timestamp updatedAt;

    // Getters and Setters
    // public int getId() {
    // return id;
    // }

    // public void setId(int id) {
    // this.id = id;
    // }

    // public Car getCar() {
    // // return car;
    // }

    // public void setCar(Car car) {
    // this.car = car;
    // }

    // public Driver getDriver() {
    // return driver;
    // }

    // public void setDriver(Driver driver) {
    // this.driver = driver;
    // }

    // public String getLocation() {
    // return location;
    // }

    // public void setLocation(String location) {
    // this.location = location;
    // }

    // public Timestamp getCreatedAt() {
    // return createdAt;
    // }

    // public void setCreatedAt(Timestamp createdAt) {
    // this.createdAt = createdAt;
    // }

    // public Timestamp getUpdatedAt() {
    // return updatedAt;
    // }

    // public void setUpdatedAt(Timestamp updatedAt) {
    // this.updatedAt = updatedAt;
    // }
}