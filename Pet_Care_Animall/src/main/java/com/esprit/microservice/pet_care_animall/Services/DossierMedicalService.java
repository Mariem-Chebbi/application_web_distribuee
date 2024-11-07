package com.esprit.microservice.pet_care_animall.Services;

import com.esprit.microservice.pet_care_animall.Entities.Animal;
import com.esprit.microservice.pet_care_animall.Entities.DossierMedical;
import com.esprit.microservice.pet_care_animall.Repositories.AnimalRepository;
import com.esprit.microservice.pet_care_animall.Repositories.DossierMedicalRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class DossierMedicalService implements IDossierMedicalService{
    private AnimalRepository animalRepository;
    private DossierMedicalRepository dossierMedicalRepository;

    public DossierMedical addDossierMedical(Long animalId, DossierMedical dossierMedical) {
        Animal animal = animalRepository.findById(animalId).orElse(null);
        if (animal != null) {
            dossierMedical.setAnimal(animal);
            return dossierMedicalRepository.save(dossierMedical);
        }
        return null;
    }

    @Transactional
    public DossierMedical editDossierMedical(Long id, DossierMedical dossierMedicalDetails) {
        DossierMedical dossierMedical = dossierMedicalRepository.findById(id).orElse(null);
        if (dossierMedical != null) {

            dossierMedical.setDiagnostic(dossierMedicalDetails.getDiagnostic());
            dossierMedical.setTraitement(dossierMedicalDetails.getTraitement());
            dossierMedical.setNotes(dossierMedicalDetails.getNotes());
        }
        return dossierMedical;
    }

    public void deleteDossierMedical(Long id) {
        dossierMedicalRepository.deleteById(id);
    }

    public List<DossierMedical> listDossiersMedical() {
        return dossierMedicalRepository.findAll();
    }

    public DossierMedical getDossierMedicalById(Long id) {
        return dossierMedicalRepository.findById(id).orElse(null);
    }
}
