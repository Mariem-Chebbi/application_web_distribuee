package com.example.pet_care_alimentation.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProduitAlimentaire {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom;
    private String description;
    private String image;
    private String type;
    private String categorie;
    private int quantite;
    private String unite;
    @ManyToOne
    private PlanAlimentaire planAlimentaire;

}
