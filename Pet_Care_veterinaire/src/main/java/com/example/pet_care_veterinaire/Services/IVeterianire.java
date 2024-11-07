package com.example.pet_care_veterinaire.Services;

import java.util.List;

import com.example.pet_care_veterinaire.entities.Veterinaire;

public interface  IVeterianire {

Veterinaire add( Veterinaire veterinaire );
Veterinaire update( Veterinaire veterinaire );
void deleate (long id );
List<Veterinaire> liste ();
   
    }