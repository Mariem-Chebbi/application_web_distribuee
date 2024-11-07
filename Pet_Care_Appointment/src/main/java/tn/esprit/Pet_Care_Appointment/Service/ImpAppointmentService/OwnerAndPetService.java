package tn.esprit.Pet_Care_Appointment.Service.ImpAppointmentService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.Pet_Care_Appointment.Entity.OwnerAndPet;
import tn.esprit.Pet_Care_Appointment.Repository.OwnerAndPetRepository;
import tn.esprit.Pet_Care_Appointment.Service.IService.IOwnerAndPetService;

import java.util.List;
import java.util.Optional;

@Service
public class OwnerAndPetService implements IOwnerAndPetService {

    @Autowired
    private OwnerAndPetRepository ownerAndPetRepository;

    @Override
    public OwnerAndPet saveOwnerAndPet(OwnerAndPet ownerAndPet) {
        return ownerAndPetRepository.save(ownerAndPet);
    }

    @Override
    public OwnerAndPet getOwnerAndPetById(Long id) {
        return ownerAndPetRepository.findById(id).orElse(null);
    }

    @Override
    public List<OwnerAndPet> getAllOwnersAndPets() {
        return ownerAndPetRepository.findAll();
    }

    @Override
    public OwnerAndPet updateOwnerAndPet(Long id, OwnerAndPet ownerAndPet) {
        Optional<OwnerAndPet> existingOwnerAndPet = ownerAndPetRepository.findById(id);
        if (existingOwnerAndPet.isPresent()) {
            OwnerAndPet updatedOwnerAndPet = existingOwnerAndPet.get();
            updatedOwnerAndPet.setOwnerName(ownerAndPet.getOwnerName());
            updatedOwnerAndPet.setPetName(ownerAndPet.getPetName());
            updatedOwnerAndPet.setPetType(ownerAndPet.getPetType());
            return ownerAndPetRepository.save(updatedOwnerAndPet);
        }
        return null;
    }

    @Override
    public void deleteOwnerAndPet(Long id) {
        ownerAndPetRepository.deleteById(id);
    }
}
