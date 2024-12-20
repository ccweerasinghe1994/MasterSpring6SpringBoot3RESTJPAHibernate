package com.example.main;

import com.example.beans.Person;
import com.example.beans.Vehicle;
import com.example.config.ProjectConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Example11 {
    public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext(ProjectConfig.class);
        Vehicle vehicle = context.getBean(Vehicle.class);
//        vehicle.setName("Bike");
        Person person1 = context.getBean(Person.class);
        System.out.println("person name: " + person1.getName());
        System.out.println("vehicle name: " + vehicle.getName());
        System.out.println("person vehicle: " + person1.getVehicle());
    }
}
