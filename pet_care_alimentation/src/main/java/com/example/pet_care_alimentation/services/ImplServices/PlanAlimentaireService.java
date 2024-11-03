package com.example.pet_care_alimentation.services.ImplServices;

import com.example.pet_care_alimentation.entities.PlanAlimentaire;
import com.example.pet_care_alimentation.entities.ProduitAlimentaire;
import com.example.pet_care_alimentation.repositories.PlanAlimentaireRepository;
import com.example.pet_care_alimentation.repositories.ProduitAlimentaireRepository;
import com.example.pet_care_alimentation.services.Iservices.IPlanAlimentaireService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@AllArgsConstructor
public class PlanAlimentaireService implements IPlanAlimentaireService {
    private ProduitAlimentaireRepository produitAlimentaireRepository;
    private PlanAlimentaireRepository planAlimentaireRepository;

    @Override
    public PlanAlimentaire addPlan(PlanAlimentaire planAlimentaire) {
        return planAlimentaireRepository.save(planAlimentaire);
    }

    @Transactional
    @Override
    public PlanAlimentaire edit(Long id, PlanAlimentaire planAlimentaire) {
        PlanAlimentaire planAlimentaireUpdated = planAlimentaireRepository.findById(id).orElse(null);
        planAlimentaireUpdated.setJour(planAlimentaire.getJour());
        planAlimentaireUpdated.setType(planAlimentaire.getType());
        planAlimentaireUpdated.setProduitAlimentaires(planAlimentaire.getProduitAlimentaires());
        return planAlimentaireUpdated;
    }

    @Override
    public void delete(Long id) {
        planAlimentaireRepository.deleteById(id);
    }

    @Override
    public List<PlanAlimentaire> list() {
        return planAlimentaireRepository.findAll();
    }

    @Override
    public PlanAlimentaire getByid(Long id) {
        return planAlimentaireRepository.findById(id).orElse(null);
    }

    @Override
    public void assignPlanToProduit(Long idPlan, List<Long> listProduitsId) {
        PlanAlimentaire planAlimentaire = planAlimentaireRepository.findById(idPlan).orElse(null);
        List<ProduitAlimentaire> produitAlimentaires = produitAlimentaireRepository.findAllById(listProduitsId);
        for (ProduitAlimentaire produitAlimentaire: produitAlimentaires){
            produitAlimentaire.setPlanAlimentaire(planAlimentaire);
        }
        produitAlimentaireRepository.saveAll(produitAlimentaires);
    }
}
