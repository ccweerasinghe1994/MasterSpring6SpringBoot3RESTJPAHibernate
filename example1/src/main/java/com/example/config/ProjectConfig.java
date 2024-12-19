package com.example.config;

import com.example.beans.Vehicle;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ProjectConfig {

    @Bean
    Vehicle vehicle(){
        Vehicle vehicle = new Vehicle();
        vehicle.setName("Honda Vizel");
        return vehicle;
    }

    @Bean
    String hello(){
        return "Hello, Spring!";
    }

    @Bean
    Integer number(){
        return 100;
    }
}
