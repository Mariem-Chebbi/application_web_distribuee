package com.example.pet_care_alimentation.services.Iservices;

import com.example.pet_care_alimentation.entities.PlanAlimentaire;
import com.example.pet_care_alimentation.entities.ProduitAlimentaire;

import java.util.List;

public interface IPlanAlimentaireService {
    PlanAlimentaire addPlan (PlanAlimentaire planAlimentaire);
    PlanAlimentaire edit (Long id,PlanAlimentaire planAlimentaire);
    void delete (Long id);
    List<PlanAlimentaire> list ();
    PlanAlimentaire getByid (Long id);
    void assignPlanToProduit (Long idPlan, List<Long> listProduitsId);
}
