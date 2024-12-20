package com.example.config;

import com.example.beans.Person;
import com.example.beans.Vehicle;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ProjectConfig {
    @Bean
    Vehicle vehicle() {
        Vehicle vehicle = new Vehicle();
        vehicle.setName("Honda Vezel");
        return vehicle;
    }

    @Bean
    Person person(Vehicle vehicle) {
        Person person = new Person();
        person.setName("John Doe");
        person.setVehicle(vehicle);
        return person;
    }
}
