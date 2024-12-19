package com.example.config;

import com.example.beans.Vehicle;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class ProjectConfig {

    @Bean(name="audiVehicle")
    Vehicle vehicle(){
        Vehicle vehicle = new Vehicle();
        vehicle.setName("Honda Vizel 1");
        return vehicle;
    }


    @Bean(value = "hondaVehicle")
    Vehicle vehicle2(){
        Vehicle vehicle = new Vehicle();
        vehicle.setName("Honda Vizel 2");
        return vehicle;
    }

    @Primary
    @Bean("ferrariVehicle")
    Vehicle vehicle3(){
        Vehicle vehicle = new Vehicle();
        vehicle.setName("Ferrari 1");
        return vehicle;
    }

}
