package com.example.apigateway.services;

import org.keycloak.OAuth2Constants;
import org.keycloak.admin.client.Keycloak;
import org.keycloak.admin.client.KeycloakBuilder;
import org.keycloak.representations.idm.UserRepresentation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service

public class UserService {


    private final Keycloak keycloak;

    public UserService(
            @Value("${keycloak.auth-server-url}") String serverUrl,
            @Value("${keycloak.realm}") String realm,
            @Value("${keycloak.resource}") String clientId,
            @Value("${keycloak.credentials.secret}") String clientSecret,
            @Value("${keycloak.username}") String username,
            @Value("${keycloak.password}") String password) {
        this.keycloak = KeycloakBuilder.builder()
                .serverUrl(serverUrl)
                .realm(realm)
                .grantType(OAuth2Constants.PASSWORD)
                .clientId(clientId)
                .clientSecret(clientSecret)
                .username(username)
                .password(password)
                .build();
    }

    public UserRepresentation getUserById(String userId) {
        return keycloak.realm("your-realm")
                .users()
                .get(userId)
                .toRepresentation();
    }

    public List<UserRepresentation> getAllUsers() {
        return keycloak.realm("your-realm")
                .users()
                .list();
    }

    public Map<String, List<String>> getUserAttributes(String userId) {
        UserRepresentation user = getUserById(userId);
        return user.getAttributes();
    }




}
