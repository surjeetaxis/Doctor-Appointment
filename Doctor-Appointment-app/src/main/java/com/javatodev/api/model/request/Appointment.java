package com.javatodev.api.model.request;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Appointment")
@Data
public class Appointment {

    @Id
    private String id;
    private String patientId;
    private String doctorId;
    private String trackingId;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private String address;
    private String description;
    private String scheduleDate;
    private String scheduleTime;
    private String reasonForVisit;
    private String status;
    private String paymentStatus;
    private String prescriptionStatus;
    private boolean isFollowUp;
    private String patientType;

    // Getters and setters
}

