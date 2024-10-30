package com.example.pet_care_alimentation.repositories;

import com.example.pet_care_alimentation.entities.PlanAlimentaire;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlanAlimentaireRepository extends JpaRepository<PlanAlimentaire,Long> {
}
