package com.esprit.microservice.pet_care_animall.Controllers;

import com.esprit.microservice.pet_care_animall.Entities.Animal;
import com.esprit.microservice.pet_care_animall.Services.IAnimalService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/Animal")
public class AnimalController {
    private IAnimalService iAnimalService;

    @PostMapping("/add")
    public Animal add(@RequestBody Animal animal) {
        return iAnimalService.addAnimal(animal);
    }

    @PutMapping("/edit/{id}")
    public Animal edit(@PathVariable Long id, @RequestBody Animal animal) {
        return iAnimalService.editAnimal(id, animal);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        iAnimalService.deleteAnimal(id);
    }

    @GetMapping("/{id}")
    public Animal getById (@PathVariable Long id) {
        return iAnimalService.getAnimalById(id);
    }

    @GetMapping()
    public List<Animal> getAll () {
        return iAnimalService.listAnimals();
    }

    @PutMapping("/affecter/{idAnimal}/{idPlan}")
    public Animal affecterPlanAnimal(@PathVariable Long idAnimal,@PathVariable Long idPlan){
        return iAnimalService.affecterPlanAnimal(idAnimal,idPlan);
    }

}
