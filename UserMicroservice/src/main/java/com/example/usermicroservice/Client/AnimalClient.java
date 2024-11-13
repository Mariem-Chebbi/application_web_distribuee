package com.example.usermicroservice.Client;


import com.example.usermicroservice.DTO.Animal;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name="pet-care-animal", url = "http://localhost:8099")

public interface AnimalClient {
    @GetMapping("/Animal/{id}")
    public Animal getById (@PathVariable Long id) ;
}
