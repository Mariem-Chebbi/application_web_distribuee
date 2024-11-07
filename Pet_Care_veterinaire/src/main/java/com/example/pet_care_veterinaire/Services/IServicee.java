package com.example.pet_care_veterinaire.Services;

import com.example.pet_care_veterinaire.entities.Servicee;
import java.util.List;

public interface IServicee {

Servicee add( Servicee servicee );
Servicee update( Servicee servicee );
void deleate (long id );
List<Servicee> liste ();
}
