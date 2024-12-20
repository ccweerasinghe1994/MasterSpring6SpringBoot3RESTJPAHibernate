package com.example.main;

import com.example.beans.Person;
import com.example.beans.Vehicle;
import com.example.config.ProjectConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Example9 {
    public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext(ProjectConfig.class);

        Vehicle vehicle1 = context.getBean(Vehicle.class);
        System.out.println(vehicle1.getName());
        Person person1 = context.getBean(Person.class);
        System.out.println(person1.getName());
        System.out.println(person1.getVehicle());
    }
}
