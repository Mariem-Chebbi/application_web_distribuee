package tn.esprit.Pet_Care_Appointment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScan;


@EnableDiscoveryClient
@EnableEurekaClient
@SpringBootApplication
public class PetCareAppointmentApplication {
    public static void main(String[] args) {
        SpringApplication.run(PetCareAppointmentApplication.class, args);
    }
}

