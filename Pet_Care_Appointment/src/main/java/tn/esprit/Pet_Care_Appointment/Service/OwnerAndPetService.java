package tn.esprit.Pet_Care_Appointment.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.Pet_Care_Appointment.Entity.OwnerAndPet;
import tn.esprit.Pet_Care_Appointment.Repository.OwnerAndPetRepository;

import java.util.List;

@Service
public class OwnerAndPetService {
    @Autowired
    private OwnerAndPetRepository ownerAndPetRepository;

    public List<OwnerAndPet> getAllOwnersAndPets() {
        return ownerAndPetRepository.findAll();
    }

    public OwnerAndPet saveOwnerAndPet(OwnerAndPet ownerAndPet) {
        return ownerAndPetRepository.save(ownerAndPet);
    }

    // Autres méthodes si nécessaire
}
