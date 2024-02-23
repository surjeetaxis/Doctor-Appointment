package com.javatodev.api.model.request;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.time.LocalDate;

@Document(collection = "Patient")
@Data
public class Patient {

    @Id
    private String id;
    private String firstName;
    private String lastName;
    private LocalDate dateOfBirth;
    private String bloodGroup;
    private String mobile;
    private String city;
    private String state;
    private String zipCode;
    private String gender;
    private String country;
    private String email;
    private String address;
    private String img;

    // Getters and setters
}

