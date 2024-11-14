package com.example.pet_care_veterinaire;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
public class PetCareVeterinaireApplication {

    public static void main(String[] args) {
        SpringApplication.run(PetCareVeterinaireApplication.class, args);
    }

}
