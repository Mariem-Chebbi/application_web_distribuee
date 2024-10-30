package com.example.pet_care_alimentation.repositories;

import com.example.pet_care_alimentation.entities.ProduitAlimentaire;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProduitAlimentaireRepository extends JpaRepository<ProduitAlimentaire,Long> {
}
