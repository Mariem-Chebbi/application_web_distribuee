package com.esprit.microservice.pet_care_animall;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class PetCareAnimallApplication {

	public static void main(String[] args) {
		SpringApplication.run(PetCareAnimallApplication.class, args);
	}

}
