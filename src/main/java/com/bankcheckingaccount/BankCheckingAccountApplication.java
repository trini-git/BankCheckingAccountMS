package com.bankcheckingaccount;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class BankCheckingAccountApplication {

	public static void main(String[] args) {
		SpringApplication.run(BankCheckingAccountApplication.class, args);
	}

}
