package com.example.main;

import com.example.beans.Vehicle;
import com.example.config.ProjectConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Example1 {
    public static void main(String[] args) {
        Vehicle vehicle = new Vehicle();
        vehicle.setName("Honda City");
        System.out.println("vehicle name from non spring bean: " + vehicle.getName());

        var context = new AnnotationConfigApplicationContext(ProjectConfig.class);

        Vehicle vehicle1 = context.getBean(Vehicle.class);
        System.out.println("vehicle name from spring bean: " + vehicle1.getName());

        String hello = context.getBean(String.class);
        System.out.println("hello from spring bean: " + hello);

        Integer number = context.getBean(Integer.class);
        System.out.println("number from spring bean: " + number);


    }
}
