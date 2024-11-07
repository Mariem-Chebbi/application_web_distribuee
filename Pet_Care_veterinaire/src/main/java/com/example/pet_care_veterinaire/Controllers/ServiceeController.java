package com.example.pet_care_veterinaire.Controllers;

import com.example.pet_care_veterinaire.Services.IServicee;
import com.example.pet_care_veterinaire.entities.Servicee;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Service")
@AllArgsConstructor
public class ServiceeController {
    private IServicee iServicee ;

    @PostMapping("/add")
    public Servicee add(@RequestBody  Servicee servicee){

        return iServicee.add(servicee);
    }

    @PutMapping("/update")
    public Servicee update(@RequestBody  Servicee servicee ){

        return iServicee.update(servicee);
    }

    @DeleteMapping("/delete/{id}")
      public void delete(@PathVariable Long  id  ){

        iServicee.deleate(id);
    }

    @GetMapping ("/getList")
    public List<Servicee> getListe( ){
        return  iServicee.liste();
    }
}
