package com.cgnexus.example_19;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {
		DataSourceAutoConfiguration.class
})
public class CgnexusSchool {

	public static void main(String[] args) {
		SpringApplication.run(CgnexusSchool.class, args);
	}

}
