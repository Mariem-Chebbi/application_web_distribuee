package com.esprit.microservice.pet_care_animall.Repositories;

import com.esprit.microservice.pet_care_animall.Entities.Animal;
import com.esprit.microservice.pet_care_animall.Entities.DossierMedical;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnimalRepository  extends JpaRepository<Animal,Long> {

}
