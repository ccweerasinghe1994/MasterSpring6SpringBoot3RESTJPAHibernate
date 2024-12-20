package com.example.main;

import com.example.beans.Person;
import com.example.beans.Vehicle;
import com.example.config.ProjectConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Example12 {
    public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext(ProjectConfig.class);
        Vehicle vehicle = context.getBean(Vehicle.class);
        vehicle.setName("Bike");
        Person person1 = context.getBean(Person.class);
        System.out.println("person name created by SPRING IOC: " + person1.getName());
        System.out.println("vehicle name created by SPRING IOC: " + vehicle);
        System.out.println("person vehicle created by SPRING IOC:: " + person1.getVehicle());
    }
}
