package com.esprit.microservice.pet_care_animall.DTO;

import jakarta.persistence.CascadeType;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Set;
@Getter
@Setter
public class PlanAlimentaire {
    private Long id;
    private String jour;
    private String type;
    private List<ProduitAlimentaire> produitAlimentaires;
}
