package com.cgnexus.example_19;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories("com.cgnexus.example_19.repository")
@EntityScan("com.cgnexus.example_19.model")
@EnableJpaAuditing(auditorAwareRef = "auditAwareImpl")
public class CgnexusSchool {

    public static void main(String[] args) {
        SpringApplication.run(CgnexusSchool.class, args);
    }

}
