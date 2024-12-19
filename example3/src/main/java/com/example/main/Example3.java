package com.example.main;

import com.example.beans.Vehicle;
import com.example.config.ProjectConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Example3 {
    public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext(ProjectConfig.class);

        Vehicle vehicle1 = context.getBean(Vehicle.class);
        System.out.println("vehicle name from spring bean: " + vehicle1.getName());
    }
}
