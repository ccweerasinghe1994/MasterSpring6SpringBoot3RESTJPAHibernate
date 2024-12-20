package com.example.config;

import com.example.beans.Vehicle;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
@ComponentScan("com.example.beans")
public class ProjectConfig {

    @Primary
    @Bean
    Vehicle vehicle1() {
        Vehicle vehicle = new Vehicle();
        vehicle.setName("Car");
        return vehicle;
    }

    @Bean
    Vehicle vehicle2() {
        Vehicle vehicle = new Vehicle();
        vehicle.setName("Bike");
        return vehicle;
    }

    @Bean
    Vehicle vehicle3() {
        Vehicle vehicle = new Vehicle();
        vehicle.setName("Bus");
        return vehicle;
    }
}
