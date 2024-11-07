package tn.esprit.Pet_Care_Appointment.Service.IService;

import tn.esprit.Pet_Care_Appointment.Entity.OwnerAndPet;

import java.util.List;

public interface IOwnerAndPetService {
    OwnerAndPet saveOwnerAndPet(OwnerAndPet ownerAndPet);
    OwnerAndPet getOwnerAndPetById(Long id);
    List<OwnerAndPet> getAllOwnersAndPets();
    OwnerAndPet updateOwnerAndPet(Long id, OwnerAndPet ownerAndPet);
    void deleteOwnerAndPet(Long id);
}