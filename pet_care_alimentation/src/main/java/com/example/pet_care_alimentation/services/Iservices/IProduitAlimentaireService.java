package com.example.pet_care_alimentation.services.Iservices;

import com.example.pet_care_alimentation.entities.PlanAlimentaire;
import com.example.pet_care_alimentation.entities.ProduitAlimentaire;

import java.util.List;

public interface IProduitAlimentaireService {
    ProduitAlimentaire add (ProduitAlimentaire produitAlimentaire);
    ProduitAlimentaire edit (Long id,ProduitAlimentaire produitAlimentaire);
    void delete (Long id);
    List<ProduitAlimentaire> list ();
    ProduitAlimentaire getById (Long id);
    void assignProduitsToPlan (List<Long> listProduitsId, Long idPlan);

}
