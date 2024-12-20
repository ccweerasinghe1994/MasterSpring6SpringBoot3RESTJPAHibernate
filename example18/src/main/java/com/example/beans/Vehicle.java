package com.example.beans;

import com.example.services.VehicleService;
import org.springframework.stereotype.Component;

@Component
public class Vehicle {
    private String name;

    private final VehicleService vehicleService;

    public Vehicle(VehicleService vehicleService) {
        this.vehicleService = vehicleService;
        System.out.println("Vehicle class is created by Spring IOC container");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void move() {
        vehicleService.moveTheVehicle();
    }

    public void playMusic() {
        vehicleService.palMusic();
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "name='" + name + '\'' +
                '}';
    }
}
