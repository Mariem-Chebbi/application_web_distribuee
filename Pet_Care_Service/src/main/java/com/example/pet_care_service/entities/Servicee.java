package com.example.pet_care_service.entities;

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
public class Servicee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
     private  Long id ;
     private  String Nom ;
     private  Type  type ;  //
     private  float Prix ;
     private  int duree ;
     private  Unite unite ;
}


