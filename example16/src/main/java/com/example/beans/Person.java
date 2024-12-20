package com.example.beans;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component("personBean")
@Lazy
public class Person {
    private String name;

    private final Vehicle vehicle;


    public Person(Vehicle vehicle) {
        this.vehicle = vehicle;
        System.out.println("Person class is created by Spring IOC container");
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }
}
