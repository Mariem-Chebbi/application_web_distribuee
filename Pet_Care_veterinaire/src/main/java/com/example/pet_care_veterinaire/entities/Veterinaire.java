package com.example.pet_care_veterinaire.entities;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor


public class Veterinaire {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
     private  Long id ;
     private  String Nom ;
     private  String  Prenom ;  
     private  String Email;
     private  Specialite specialite ;
    
}
