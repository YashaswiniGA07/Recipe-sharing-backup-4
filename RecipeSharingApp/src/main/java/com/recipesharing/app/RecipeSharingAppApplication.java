package com.recipesharing.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication
@ComponentScan(basePackages = "com.recipesharing.app")
public class RecipeSharingAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(RecipeSharingAppApplication.class, args);
	}
	}


