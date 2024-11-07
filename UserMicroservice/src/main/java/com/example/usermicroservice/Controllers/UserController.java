package com.example.usermicroservice.Controllers;

import com.example.usermicroservice.services.KeyCloackUserService;
import lombok.extern.slf4j.Slf4j;
import org.keycloak.representations.idm.UserRepresentation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;
@Slf4j
@RestController
@RequestMapping("/keycloak")
public class UserController {

    @Autowired
    private KeyCloackUserService keycloakUserService;

    @GetMapping("/users")
    public List<UserRepresentation> getAllUsers() {

        log.info(" KEY CLOACK {}",keycloakUserService.keycloak.realms().findAll());

        return keycloakUserService.getAllUsers() ;
    }

    @GetMapping("/user/attributes/{userId}")
    public Map<String, List<String>> getUserAttributes(@PathVariable("userId") String userId) {
        log.info("Get user attributes for {}", userId);
        return keycloakUserService.getUserAttributes(userId);
    }
    @GetMapping("/hello")
    public String Hello() {

        return "Hello";
    }
}