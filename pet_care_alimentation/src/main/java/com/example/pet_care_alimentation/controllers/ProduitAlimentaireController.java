package com.example.pet_care_alimentation.controllers;

import com.example.pet_care_alimentation.entities.ProduitAlimentaire;
import com.example.pet_care_alimentation.services.Iservices.IProduitAlimentaireService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/ProduitAlimentaire")
public class ProduitAlimentaireController {
    private IProduitAlimentaireService iProduitAlimentaireService;

    @PostMapping("/add")
    public ProduitAlimentaire add(@RequestBody ProduitAlimentaire produitAlimentaire) {
        return iProduitAlimentaireService.add(produitAlimentaire);
    }

    @PutMapping("/edit/{id}")
    public ProduitAlimentaire edit(@PathVariable Long id, @RequestBody ProduitAlimentaire produitAlimentaire) {
        return iProduitAlimentaireService.edit(id, produitAlimentaire);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        iProduitAlimentaireService.delete(id);
    }

    @GetMapping("/{id}")
    public ProduitAlimentaire getById (@PathVariable Long id) {
        return iProduitAlimentaireService.getById(id);
    }

    @GetMapping()
    public List<ProduitAlimentaire> getAll () {
        return iProduitAlimentaireService.list();
    }
}
