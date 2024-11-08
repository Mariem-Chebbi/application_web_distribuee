package com.example.usermicroservice.entities;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class User {

     private String username;
    private String password;
    private String firstName;
    private String lastName;
    private String email;
    private String role;

    private LocalDateTime lastSubDate;

    // No need for explicit getters and setters due to Lombok annotations
}
