package com.esprit.microservice.pet_care_animall.Services;

import com.esprit.microservice.pet_care_animall.Alimentation.Alimentation;
import com.esprit.microservice.pet_care_animall.DTO.PlanAlimentaire;
import com.esprit.microservice.pet_care_animall.Entities.Animal;
import com.esprit.microservice.pet_care_animall.Entities.DossierMedical;
import com.esprit.microservice.pet_care_animall.Repositories.AnimalRepository;
import com.esprit.microservice.pet_care_animall.Repositories.DossierMedicalRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class AnimalService implements IAnimalService{
    private AnimalRepository animalRepository;
    private DossierMedicalRepository dossierMedicalRepository;
    private Alimentation alimentation;

    public Animal addAnimal (Animal animal){
        return animalRepository.save(animal);
    }
    @Transactional
    public Animal editAnimal(Long id, Animal animal) {
        Animal animalUpadated = animalRepository.findById(id).orElse(null);

            animal.setNom(animal.getNom());
            animal.setEspece(animal.getEspece());
            animal.setRace(animal.getRace());
            animal.setAge(animal.getAge());
            animal.setSexe(animal.getSexe());

        return animalUpadated;
    }

    public void deleteAnimal(Long id) {
        animalRepository.deleteById(id);
    }

    public List<Animal> listAnimals() {
        return animalRepository.findAll();
    }

    public Animal getAnimalById(Long id) {
        return animalRepository.findById(id).orElse(null);
    }

    public Animal affecterPlanAnimal(Long idAnimal,Long idPlan){
        Animal animal =  animalRepository.findById(idAnimal).orElse(null) ;
        PlanAlimentaire planAlimentaire = alimentation.getById(idPlan);
        if ( animal.getListPlanAlimentation()==null) {
           animal.setListPlanAlimentation(new ArrayList<>());
            animal.getListPlanAlimentation().add(planAlimentaire.getId());
        }else {
            animal.getListPlanAlimentation().add(planAlimentaire.getId());
        }
        return animalRepository.save(animal);
    }
}
