package tn.esprit.Pet_Care_Appointment.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.Pet_Care_Appointment.Entity.OwnerAndPet;
import tn.esprit.Pet_Care_Appointment.Service.IService.IOwnerAndPetService;


import java.util.List;

@RestController
@RequestMapping("/owners-and-pets")
public class OwnerAndPetController {

    @Autowired
    private IOwnerAndPetService ownerAndPetService;

    @GetMapping
    public List<OwnerAndPet> getAllOwnersAndPets() {
        return ownerAndPetService.getAllOwnersAndPets();
    }

    @GetMapping("/{id}")
    public OwnerAndPet getOwnerAndPetById(@PathVariable Long id) {
        return ownerAndPetService.getOwnerAndPetById(id);
    }

    @PostMapping
    public OwnerAndPet createOwnerAndPet(@RequestBody OwnerAndPet ownerAndPet) {
        return ownerAndPetService.saveOwnerAndPet(ownerAndPet);
    }

    @PutMapping("/{id}")
    public OwnerAndPet updateOwnerAndPet(@PathVariable Long id, @RequestBody OwnerAndPet ownerAndPet) {
        return ownerAndPetService.updateOwnerAndPet(id, ownerAndPet);
    }

    @DeleteMapping("/{id}")
    public void deleteOwnerAndPet(@PathVariable Long id) {
        ownerAndPetService.deleteOwnerAndPet(id);
    }
}
