package com.example.pet_care_alimentation.services.ImplServices;

import com.example.pet_care_alimentation.entities.PlanAlimentaire;
import com.example.pet_care_alimentation.entities.ProduitAlimentaire;
import com.example.pet_care_alimentation.repositories.PlanAlimentaireRepository;
import com.example.pet_care_alimentation.repositories.ProduitAlimentaireRepository;
import com.example.pet_care_alimentation.services.Iservices.IProduitAlimentaireService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Set;

@Service
@AllArgsConstructor
public class ProduitAlimentaireService implements IProduitAlimentaireService {
    private ProduitAlimentaireRepository produitAlimentaireRepository;
    private PlanAlimentaireRepository planAlimentaireRepository;

    @Override
    public ProduitAlimentaire add(ProduitAlimentaire produitAlimentaire) {
        return produitAlimentaireRepository.save(produitAlimentaire);
    }

    @Transactional
    @Override
    public ProduitAlimentaire edit(Long id, ProduitAlimentaire produitAlimentaire) {
        ProduitAlimentaire produitAlimentaireUpdated = produitAlimentaireRepository.findById(id).orElse(null);
        produitAlimentaireUpdated.setNom(produitAlimentaire.getNom());
        produitAlimentaireUpdated.setCategorie(produitAlimentaire.getCategorie());
        produitAlimentaireUpdated.setDescription(produitAlimentaire.getDescription());
        produitAlimentaireUpdated.setImage(produitAlimentaire.getImage());
        produitAlimentaireUpdated.setQuantite(produitAlimentaire.getQuantite());
        produitAlimentaireUpdated.setUnite(produitAlimentaire.getUnite());
        produitAlimentaireUpdated.setType(produitAlimentaire.getType());
        produitAlimentaireUpdated.setPlanAlimentaire(produitAlimentaire.getPlanAlimentaire());
        return produitAlimentaireUpdated;
    }

    @Override
    public void delete(Long id) {
        produitAlimentaireRepository.deleteById(id);
    }

    @Override
    public List<ProduitAlimentaire> list() {
        return produitAlimentaireRepository.findAll();
    }

    @Override
    public ProduitAlimentaire getById(Long id) {
        return produitAlimentaireRepository.findById(id).orElse(null);
    }

    @Override
    public void assignProduitsToPlan(List<Long> listProduitsId, Long idPlan) {
        PlanAlimentaire planAlimentaire = planAlimentaireRepository.findById(idPlan).orElse(null);
        List<ProduitAlimentaire> produitAlimentaires = produitAlimentaireRepository.findAllById(listProduitsId);

        planAlimentaire.getProduitAlimentaires().addAll(produitAlimentaires);
        planAlimentaireRepository.save(planAlimentaire);
    }

}
