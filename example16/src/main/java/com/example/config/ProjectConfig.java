package com.example.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = {
        "com.example.services",
        "com.example.implementations",
})
@ComponentScan(
        basePackageClasses = {
                com.example.beans.Vehicle.class
        }
)
public class ProjectConfig {

}
