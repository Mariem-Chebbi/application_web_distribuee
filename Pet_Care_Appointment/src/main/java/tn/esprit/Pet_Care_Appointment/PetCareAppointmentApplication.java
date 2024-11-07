package tn.esprit.Pet_Care_Appointment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(basePackages = "tn.esprit.Pet_Care_Appointment.Service")
@SpringBootApplication
public class PetCareAppointmentApplication {

	public static void main(String[] args) {
		SpringApplication.run(PetCareAppointmentApplication.class, args);
	}

}
