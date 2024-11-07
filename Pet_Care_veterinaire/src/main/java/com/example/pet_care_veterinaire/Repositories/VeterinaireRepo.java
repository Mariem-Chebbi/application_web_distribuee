package com.example.pet_care_veterinaire.Repositories;


import com.example.pet_care_veterinaire.entities.Veterinaire;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VeterinaireRepo extends JpaRepository  <Veterinaire, Long > {
    
}
