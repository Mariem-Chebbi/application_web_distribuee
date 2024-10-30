package com.example.pet_care_alimentation.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PlanAlimentaire {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String jour;
    private String type;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "planAlimentaire")
    private Set<ProduitAlimentaire> produitAlimentaires;

}
