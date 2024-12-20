package com.example.main;

import com.example.config.ProjectConfig;
import com.example.services.VehicleService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Example17 {
    public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext(ProjectConfig.class);
        VehicleService vehicleService1 = context.getBean(VehicleService.class);
        VehicleService vehicleService2 = context.getBean("vehicleService", VehicleService.class);

        System.out.println("Vehicle Service1 HashCode :" + vehicleService1.hashCode());
        System.out.println("Vehicle Service2 HashCode :" + vehicleService2.hashCode());

        if (vehicleService1 == vehicleService2) {
            System.out.println("equal");
        } else {
            System.out.println("not equal");
        }

    }
}
