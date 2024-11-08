package com.esprit.microservice.pet_care_animall.Alimentation;

import com.esprit.microservice.pet_care_animall.DTO.PlanAlimentaire;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name="pet-care-alimentation", url = "http://localhost:8090")
public interface Alimentation {
    @GetMapping("/PlanAlimentaire/{id}")
    public PlanAlimentaire getById (@PathVariable Long id);
}
