package tn.esprit.Pet_Care_Appointment.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.Pet_Care_Appointment.Entity.OwnerAndPet;

public interface OwnerAndPetRepository extends JpaRepository<OwnerAndPet, Long> {}
