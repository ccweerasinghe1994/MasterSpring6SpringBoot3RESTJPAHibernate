package com.example.beans;

import org.springframework.beans.factory.annotation.Autowired;

public class Vehicle {
    private String name;

    @Autowired
    private Person person;

    public Vehicle() {
        System.out.println("Vehicle class is created by Spring IOC container");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "name='" + name + '\'' +
                '}';
    }
}
