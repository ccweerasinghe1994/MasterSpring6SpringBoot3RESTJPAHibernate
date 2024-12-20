package com.example.beans;

public class Vehicle {
    private String name;

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
