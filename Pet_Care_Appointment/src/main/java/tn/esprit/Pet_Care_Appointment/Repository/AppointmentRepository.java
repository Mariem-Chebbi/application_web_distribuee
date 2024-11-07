package tn.esprit.Pet_Care_Appointment.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.Pet_Care_Appointment.Entity.Appointment;

public interface AppointmentRepository extends JpaRepository<Appointment, Long> {}
