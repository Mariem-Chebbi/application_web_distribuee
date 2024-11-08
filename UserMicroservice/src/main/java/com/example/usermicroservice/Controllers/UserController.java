package com.example.usermicroservice.Controllers;

import com.example.usermicroservice.entities.User;
import com.example.usermicroservice.services.KeyCloackUserService;
import com.example.usermicroservice.services.UserService;
import jakarta.ws.rs.core.Response;
import lombok.extern.slf4j.Slf4j;
import org.keycloak.admin.client.Keycloak;
import org.keycloak.representations.idm.UserRepresentation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
@Slf4j
@RestController
@RequestMapping("/keycloak")
public class UserController {

    @Autowired
    private KeyCloackUserService keycloakUserService;

    @Autowired
    private UserService userService;

    @GetMapping("/users")
    public List<UserRepresentation> getAllUsers() {



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

    @PostMapping
    @RequestMapping("/register")
    public Response createUser (@RequestBody User user) {
        System.out.println("REGISTERING");
        UserRepresentation userRep = userService.mapAdminRep(user);
        Keycloak keycloak = KeyCloackUserService.getInstance();
        Response response = keycloak.realm("master").users().create(userRep);
        return Response.ok (user).build();
    }
}