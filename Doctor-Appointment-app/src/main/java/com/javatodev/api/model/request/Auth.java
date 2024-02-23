package com.javatodev.api.model.request;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Auth")
@Data
public class Auth {
    @Id
    private String id;
    private String email;
    private String password;
    private String userId;
    private String role;
    private String accessToken;

    // Constructors, getters, setters

    public enum UserRole {
        ADMIN,
        PATIENT,
        DOCTOR
    }
}

