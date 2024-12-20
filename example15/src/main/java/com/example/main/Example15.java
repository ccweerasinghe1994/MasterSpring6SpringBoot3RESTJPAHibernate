package com.example.main;

import com.example.config.ProjectConfig;
import com.example.services.VehicleService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Example15 {
    public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext(ProjectConfig.class);
        VehicleService vehicleService1 = context.getBean(VehicleService.class);
        VehicleService vehicleService2 = context.getBean("vehicleService", VehicleService.class);

        System.out.println("Hashcode of vehicleService1: " + vehicleService1.hashCode());
        System.out.println("Hashcode of vehicleService2: " + vehicleService2.hashCode());

        if (vehicleService1 == vehicleService2) {
            System.out.println("Both beans are same");
        } else {
            System.out.println("Both beans are different");
        }
    }
}
