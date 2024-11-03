package com.example.pet_care_service.Repositories;

import com.example.pet_care_service.entities.Servicee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ServiceeRepo  extends JpaRepository <Servicee, Long > {
}
