package com.example.pet_care_alimentation.controllers;

import com.example.pet_care_alimentation.entities.PlanAlimentaire;
import com.example.pet_care_alimentation.entities.ProduitAlimentaire;
import com.example.pet_care_alimentation.services.Iservices.IPlanAlimentaireService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/PlanAlimentaire")
public class PlanAlimentaireController {
    private IPlanAlimentaireService iPlanAlimentaireService;


    @PostMapping("/add")
    public PlanAlimentaire add(@RequestBody PlanAlimentaire planAlimentaire) {
        return iPlanAlimentaireService.addPlan(planAlimentaire);
    }

    @PutMapping("/edit/{id}")
    public PlanAlimentaire edit(@PathVariable Long id, @RequestBody PlanAlimentaire planAlimentaire) {
        return iPlanAlimentaireService.edit(id, planAlimentaire);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        iPlanAlimentaireService.delete(id);
    }

    @GetMapping("/{id}")
    public PlanAlimentaire getById (@PathVariable Long id) {
        return iPlanAlimentaireService.getByid(id);
    }

    @GetMapping()
    public List<PlanAlimentaire> getAll () {
        return iPlanAlimentaireService.list();
    }

    @PutMapping("/assign/{idPlan}")
    public void assignPlanToProduit(@RequestParam Long idPlan,@RequestBody List<Long> listProduitsId) {
        iPlanAlimentaireService.assignPlanToProduit(idPlan,listProduitsId);
    }
}
