package com.sima.customers;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories(basePackages = "com.sima.customers.repository")
@SpringBootApplication
public class CustomersApplication {

	public static void main(String[] args) {
		SpringApplication.run(CustomersApplication.class, args);
	}

}
