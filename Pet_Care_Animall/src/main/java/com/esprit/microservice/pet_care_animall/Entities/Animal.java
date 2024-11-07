package com.esprit.microservice.pet_care_animall.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Animal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom;
    private String espece;
    private String race;
    private int age;
    private String sexe;

    @OneToOne(mappedBy = "animal", cascade = CascadeType.ALL)
    private DossierMedical dossierMedical ;
}
