package com.javatodev.api.model.request;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Reviews")
@Data
public class Review {

    @Id
    private String id;
    private String doctorId;
    private String patientId;
    private String description;
    private String star;
    private boolean isRecommended;
    private String response;

    // Getters and setters
}

