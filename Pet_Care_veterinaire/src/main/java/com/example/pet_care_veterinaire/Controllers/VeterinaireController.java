package com.example.pet_care_veterinaire.Controllers;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import com.example.pet_care_veterinaire.Services.IVeterianire;
import com.example.pet_care_veterinaire.entities.Veterinaire;

import java.util.List;

@RestController
@RequestMapping("/Veterinaire")
@AllArgsConstructor
public class VeterinaireController {

private IVeterianire iVeterianire ;


    @PostMapping("/add")
    public Veterinaire add(@RequestBody  Veterinaire veterinaire){

        return iVeterianire.add(veterinaire);
    }

    @PutMapping("/update")
    public Veterinaire update(@RequestBody  Veterinaire veterinaire ){

        return iVeterianire.update(veterinaire);
    }

    @DeleteMapping("/delete/{id}")
      public void delete(@PathVariable Long  id  ){

        iVeterianire.deleate(id);
    }

    @GetMapping ("/getList")
    public List<Veterinaire> getListe( ){
        return  iVeterianire.liste();
    }

    
}
