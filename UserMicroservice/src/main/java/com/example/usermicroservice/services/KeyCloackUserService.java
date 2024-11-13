package com.example.usermicroservice.services;


import com.example.usermicroservice.Client.AnimalClient;
import com.example.usermicroservice.DTO.Animal;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.keycloak.OAuth2Constants;
import org.keycloak.admin.client.Keycloak;
import org.keycloak.admin.client.KeycloakBuilder;
import org.keycloak.representations.idm.UserRepresentation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@Slf4j
@RequiredArgsConstructor
public class KeyCloackUserService {


    public static   Keycloak keycloak = null;
    private static String realmName = "master";

    @Autowired
    private AnimalClient animalClient;



    public KeyCloackUserService(
            AnimalClient animalClient

           ) {

        this.keycloak = KeycloakBuilder.builder()
                .serverUrl("http://localhost:8080")
                .grantType(OAuth2Constants.PASSWORD)
                .realm(realmName)
                .clientId("admin-cli")
                .username("admin")
                .password("admin")
                .build();


       // keycloak.tokenManager().getAccessToken();



    }
    @Bean
    public static Keycloak getInstance() {
        if (keycloak == null) {
            keycloak = KeycloakBuilder.builder()
                    .serverUrl("http://localhost:8080")
                    .grantType(OAuth2Constants.PASSWORD)
                    .realm("master")
                    .clientId("admin-cli")
                    .username("admin")
                    .password("admin")
                    .build();
        }
        return keycloak;
    }
    public UserRepresentation getUserById(String userId) {
        return keycloak.realm(realmName)
                .users()
                .get(userId)
                .toRepresentation();
    }

    public List<UserRepresentation> getAllUsers() {
        return keycloak.realm(realmName)
                .users()
                .list();
    }

    public Map<String, List<String>> getUserAttributes(String userId) {
        UserRepresentation user = getUserById(userId);
        return user.getAttributes();
    }

    public String AffectAnimal(String UserId,Long AnimalId) {
        UserRepresentation user = getUserById(UserId);
        Animal animalDTO = animalClient.getById(AnimalId);

        Map<String, List<String>> attributes = user.getAttributes();
        if (attributes == null) {
            attributes = new HashMap<>();
        }

        List<String> animalsList = attributes.getOrDefault("animals", new ArrayList<>());


        animalsList.add("Nom Animal " + animalDTO.getNom());

        attributes.put("animals", animalsList);
        user.setAttributes(attributes);

        keycloak.realm(realmName).users().get(UserId).update(user);
        return "Animal successfully assigned to user.";
    }




}
