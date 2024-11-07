package com.example.pet_care_service.Services;

import com.example.pet_care_service.Repositories.VeterinaireRepo;
import com.example.pet_care_service.entities.Veterinaire;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@AllArgsConstructor
public class VeterinaireService implements IVeterianire {
    
    
     private VeterinaireRepo rep ;
    @Override
    public Veterinaire add(Veterinaire veterinaire) {
        return rep.save(veterinaire) ;

    }


   @Transactional
    @Override
    public Veterinaire update(Veterinaire veterinaire) {
         Veterinaire S = rep.findById(veterinaire.getId()).orElse(null);
        S.setNom(veterinaire.getNom());
        S.setPrenom(veterinaire.getPrenom());
        S.setEmail(veterinaire.getEmail());
        S.setSpecialite(veterinaire.getSpecialite());

        return S ;
    }

    @Override
    public void deleate(long id) {
        Veterinaire S = rep.findById(id).orElse(null);
        rep.delete(S);
    }

    @Override
    public List<Veterinaire> liste() {
        return rep.findAll();
    }
    
}
