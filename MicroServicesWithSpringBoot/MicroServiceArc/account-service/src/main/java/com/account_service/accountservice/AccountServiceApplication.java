package com.account_service.accountservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;




@SpringBootApplication
public class AccountServiceApplication {

	public static void main(String[] args) {
		System.setProperty("spring.config.name", "application");
		SpringApplication.run(AccountServiceApplication.class, args);



	}

}
