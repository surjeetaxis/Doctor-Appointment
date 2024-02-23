package com.javatodev.api.model.request;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Medicine")
@Data
public class Medicine {

    @Id
    private String id;
    private String prescriptionId;
    private String medicine;
    private String dosage;
    private String frequency;
    private String duration;

    // Getters and setters
}
