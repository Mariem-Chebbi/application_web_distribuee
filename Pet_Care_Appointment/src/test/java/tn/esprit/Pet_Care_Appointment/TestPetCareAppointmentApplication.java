package tn.esprit.Pet_Care_Appointment;

import org.springframework.boot.SpringApplication;

public class TestPetCareAppointmentApplication {

	public static void main(String[] args) {
		SpringApplication.from(PetCareAppointmentApplication::main).with(TestcontainersConfiguration.class).run(args);
	}

}
