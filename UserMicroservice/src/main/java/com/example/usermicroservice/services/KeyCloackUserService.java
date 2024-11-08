package com.example.usermicroservice.services;


import lombok.extern.slf4j.Slf4j;
import org.jboss.resteasy.client.jaxrs.ResteasyClientBuilder;
import org.jboss.resteasy.client.jaxrs.internal.ResteasyClientBuilderImpl;
import org.keycloak.OAuth2Constants;
import org.keycloak.admin.client.Keycloak;
import org.keycloak.admin.client.KeycloakBuilder;
import org.keycloak.admin.client.resource.RealmResource;
import org.keycloak.representations.idm.UserRepresentation;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
@Slf4j

public class KeyCloackUserService {


    public static   Keycloak keycloak = null;

    public KeyCloackUserService(
            @Value("${keycloak.auth-server-url}") String serverUrl,
            @Value("${keycloak.realm}") String realm,
            @Value("${keycloak.clientid}") String clientId,
            @Value("${keycloak.grantype}") String grantype,
            @Value("${keycloak.username}") String username,
            @Value("${keycloak.credentials.secret}") String secret,
            @Value("${keycloak.password}") String password) {

        this.keycloak = KeycloakBuilder.builder()
                .serverUrl("http://localhost:8080")
                .grantType(OAuth2Constants.PASSWORD)
                .realm("master")
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
        return keycloak.realm("master")
                .users()
                .get(userId)
                .toRepresentation();
    }

    public List<UserRepresentation> getAllUsers() {
        return keycloak.realm("master")
                .users()
                .list();
    }

    public Map<String, List<String>> getUserAttributes(String userId) {
        UserRepresentation user = getUserById(userId);
        return user.getAttributes();
    }




}
