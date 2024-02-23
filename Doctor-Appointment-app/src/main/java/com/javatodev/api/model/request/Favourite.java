package com.javatodev.api.model.request;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Favourite")
public class Favourite {

    @Id
    private String id;
    private String doctorId;
    private String patientId;

    // Getters and setters
}

