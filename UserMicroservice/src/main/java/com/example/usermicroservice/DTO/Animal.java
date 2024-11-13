package com.example.usermicroservice.DTO;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Animal {


    private Long id;
    private String nom;
    private String espece;
    private String race;
    private Integer age;
    private String sexe;

    private List<Long> listPlanAlimentation;

    private DossierMedical dossierMedical ;




}
