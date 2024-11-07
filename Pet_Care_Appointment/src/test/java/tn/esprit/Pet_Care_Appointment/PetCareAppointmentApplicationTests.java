package tn.esprit.Pet_Care_Appointment;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit4.SpringRunner;

import tn.esprit.Pet_Care_Appointment.Service.IService.IAppointmentService;


@RunWith(SpringRunner.class)
@Import(TestcontainersConfiguration.class)
@SpringBootTest
class PetCareAppointmentApplicationTests {

	@Test
	void contextLoads() {
	}

	@MockBean
    private IAppointmentService appointmentService;
}

