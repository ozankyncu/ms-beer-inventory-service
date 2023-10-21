package com.kyncu.msbeerinventoryservice.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jms.artemis.ArtemisAutoConfiguration;

@SpringBootApplication(exclude = ArtemisAutoConfiguration.class)
public class MsBeerInventoryServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsBeerInventoryServiceApplication.class, args);
	}

}
