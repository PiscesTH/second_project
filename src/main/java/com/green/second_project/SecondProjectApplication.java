package com.green.second_project;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;

@SpringBootApplication
@ConfigurationPropertiesScan
public class SecondProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(SecondProjectApplication.class, args);
	}

}
