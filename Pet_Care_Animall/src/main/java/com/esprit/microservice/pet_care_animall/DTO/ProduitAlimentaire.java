package com.esprit.microservice.pet_care_animall.DTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProduitAlimentaire {
    private Long id;
    private String nom;
    private String description;
    private String image;
    private String type;
    private String categorie;
    private int quantite;
    private String unite;
}
