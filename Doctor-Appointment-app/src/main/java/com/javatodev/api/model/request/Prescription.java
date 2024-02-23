package com.javatodev.api.model.request;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Prescription {
    @Id
    private String id;
    private String doctorId;
    private String patientId;
    private String appointmentId;
    private String followUpDate;
    private String instruction;
    private boolean isFulfilled;
    private boolean isArchived;
    private String diagnosis;
    private String disease;
    private String test;
    // Getters and setters
}

