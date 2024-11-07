package com.esprit.microservice.pet_care_animall.Services;

import com.esprit.microservice.pet_care_animall.Entities.Animal;
import com.esprit.microservice.pet_care_animall.Entities.DossierMedical;

import java.util.List;

public interface IDossierMedicalService {
    DossierMedical addDossierMedical (Long animalId,DossierMedical dossierMedical);
    DossierMedical editDossierMedical (Long id,DossierMedical dossierMedical);
    void deleteDossierMedical (Long id);
    List<DossierMedical> listDossiersMedical ();
    DossierMedical getDossierMedicalById (Long id);
}
