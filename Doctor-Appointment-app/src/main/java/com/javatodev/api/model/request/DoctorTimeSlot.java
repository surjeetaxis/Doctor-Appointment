package com.javatodev.api.model.request;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "DoctorTimeSlot")
public class DoctorTimeSlot {

    @Id
    private String id;
    private String doctorId;
    private String day;
    private String weekDay;
    private int maximumPatient;

    // Getters and setters
}
