package com.esprit.microservice.pet_care_animall.Controllers;

import com.esprit.microservice.pet_care_animall.Entities.DossierMedical;
import com.esprit.microservice.pet_care_animall.Services.IDossierMedicalService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/DossierMedical")
public class DossierMedicalController {
    private IDossierMedicalService iDossierMedicalService;

    @PostMapping("/add/{animalId}")
    public DossierMedical add(@PathVariable Long animalId, @RequestBody DossierMedical dossierMedical) {
       return iDossierMedicalService.addDossierMedical(animalId, dossierMedical);
    }

    @PutMapping("/edit/{id}")
    public DossierMedical edit(@PathVariable Long id, @RequestBody DossierMedical dossierMedicalDetails) {
       return iDossierMedicalService.editDossierMedical(id, dossierMedicalDetails);

    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
       iDossierMedicalService.deleteDossierMedical(id);
    }

    @GetMapping
    public List<DossierMedical> listDossiersMedical() {
        return iDossierMedicalService.listDossiersMedical();
    }

    @GetMapping("/{id}")
    public DossierMedical getDossierMedicalById(@PathVariable Long id) {
        return iDossierMedicalService.getDossierMedicalById(id);

    }

}
