package com.example.main;

import com.example.beans.Vehicle;
import com.example.config.ProjectConfig;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Random;
import java.util.function.Supplier;

public class Example5 {
    public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext(ProjectConfig.class);

        Vehicle volkswagen = new Vehicle();
        volkswagen.setName("Volkswagen");
        Supplier<Vehicle> volkswagenSupplier = () -> volkswagen;

        Supplier<Vehicle> audiSupplier = () -> {
            Vehicle audi = new Vehicle();
            audi.setName("Audi");
            return audi;
        };

        Random random = new Random();
        int randomInt = random.nextInt(10);
        System.out.println("Random number: " + randomInt);

        if (randomInt % 2 == 0) {
            context.registerBean("volkswagen", Vehicle.class, volkswagenSupplier);

        } else {
            context.registerBean("audi", Vehicle.class, audiSupplier);
        }

        try {
            Vehicle volkswagenBean = context.getBean("volkswagen", Vehicle.class);
            System.out.println("Bean with name 'volkswagen' found");
        } catch (NoSuchBeanDefinitionException e) {
            System.out.println("Bean with name 'volkswagen' not found");
        }

        try {
            Vehicle audiBean = context.getBean("audi", Vehicle.class);
            System.out.println("Bean with name 'audi' found");
        } catch (NoSuchBeanDefinitionException e) {
            System.out.println("Bean with name 'audi' not found");
        }
    }
}
