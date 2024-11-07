package tn.esprit.Pet_Care_Appointment.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import tn.esprit.Pet_Care_Appointment.Entity.OwnerAndPet;
import tn.esprit.Pet_Care_Appointment.Service.OwnerAndPetService;

import java.util.List;

@RestController
@RequestMapping("/owners-and-pets")
public class OwnerAndPetController {
    @Autowired
    private OwnerAndPetService ownerAndPetService;

    @GetMapping
    public List<OwnerAndPet> getAllOwnersAndPets() {
        return ownerAndPetService.getAllOwnersAndPets();
    }

    @PostMapping
    public OwnerAndPet createOwnerAndPet(@RequestBody OwnerAndPet ownerAndPet) {
        return ownerAndPetService.saveOwnerAndPet(ownerAndPet);
    }
}
