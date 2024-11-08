package com.example.usermicroservice.services;


import com.example.usermicroservice.entities.User;
import org.keycloak.admin.client.Keycloak;
import org.keycloak.representations.AccessTokenResponse;
import org.keycloak.representations.idm.CredentialRepresentation;
import org.keycloak.representations.idm.UserRepresentation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


@Service
public class UserService {


    @Autowired
    private Keycloak keycloak; // Inject the Keycloak instance

    private User mapUser (UserRepresentation userRep) {
        User user = new User();
        user.setFirstName (userRep.getFirstName());
        user.setLastName (userRep.getLastName() );
        user.setEmail (userRep.getEmail());
        user.setUsername (userRep.getUsername() );
        return user;
    }
    public UserRepresentation mapUserRep(User user) {
        UserRepresentation userRep = new UserRepresentation();
         userRep.setUsername (user.getUsername()  );
        userRep.setFirstName (user.getFirstName());
        userRep.setLastName (user.getLastName());
        userRep.setEmail (user.getEmail());
        userRep.setEnabled(true);
        userRep.setEmailVerified(true);
        List<String> realmRoles = new ArrayList<>();
        realmRoles.add("USER");
        userRep.setRealmRoles(realmRoles);
        List<CredentialRepresentation> creds = new ArrayList<>();
        CredentialRepresentation cred = new CredentialRepresentation();
        cred.setTemporary (false);
        cred.setValue(user.getPassword());
        creds.add(cred);
        userRep.setCredentials (creds);
        return userRep;
    }

    public UserRepresentation mapAdminRep(User user) {
        UserRepresentation userRep = new UserRepresentation();
        userRep.setUsername (user.getUsername()  );
        userRep.setFirstName (user.getFirstName());
        userRep.setLastName (user.getLastName());
        userRep.setEmail (user.getEmail());
        userRep.setEnabled(true);
        userRep.setEmailVerified(true);
        List<String> realmRoles = new ArrayList<>();
        realmRoles.add("admin");
        userRep.setRealmRoles(realmRoles);
        List<CredentialRepresentation> creds = new ArrayList<>();
        CredentialRepresentation cred = new CredentialRepresentation();
        cred.setTemporary (false);
        cred.setValue(user.getPassword());
        creds.add(cred);
        userRep.setCredentials (creds);
        return userRep;
    }


//    public String loginUser(String username, String password) {
//        Keycloak keycloak = KeyCloackUserService.loginAsUser(username, password);
//
//        // Request an access token
//        AccessTokenResponse tokenResponse = keycloak.tokenManager().getAccessToken();
//        return tokenResponse.getToken(); // Return the access token
//    }
//    public Map<String, Object> getUserInfo(String token) {
//        RestTemplate restTemplate = new RestTemplate();
//
//        // Keycloak /userinfo endpoint
//        String userInfoEndpoint = KeyCloackUserService.serverUrl + "/realms/" + KeycloakConfig.realm + "/protocol/openid-connect/userinfo";
//
//        // Set up headers with Authorization Bearer token
//        HttpHeaders headers = new HttpHeaders();
//        headers.setBearerAuth(token);  // Attach token
//
//        // Create the request entity (headers only)
//        HttpEntity<String> entity = new HttpEntity<>(headers);
//
//        // Send GET request to the /userinfo endpoint
//        ResponseEntity<Map> response = restTemplate.exchange(userInfoEndpoint, HttpMethod.GET, entity, Map.class);
//
//        // Return the user info as a map
//        return response.getBody();
//    }
}
