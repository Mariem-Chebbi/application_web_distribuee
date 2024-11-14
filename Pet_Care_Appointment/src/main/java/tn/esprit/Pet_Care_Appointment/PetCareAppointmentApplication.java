package tn.esprit.Pet_Care_Appointment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;


@SpringBootApplication
@EnableDiscoveryClient
public class PetCareAppointmentApplication {
    public static void main(String[] args) {
        SpringApplication.run(PetCareAppointmentApplication.class, args);
    }
}

