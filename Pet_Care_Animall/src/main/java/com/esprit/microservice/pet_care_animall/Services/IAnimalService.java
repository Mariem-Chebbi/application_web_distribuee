package com.esprit.microservice.pet_care_animall.Services;

import com.esprit.microservice.pet_care_animall.Entities.Animal;

import java.util.List;

public interface IAnimalService {
    Animal addAnimal (Animal animal);
    Animal editAnimal (Long id,Animal animal);
    void deleteAnimal (Long id);
    List<Animal> listAnimals ();
    Animal getAnimalById (Long id);
    public Animal affecterPlanAnimal(Long idAnimal,Long idPlan);

}
