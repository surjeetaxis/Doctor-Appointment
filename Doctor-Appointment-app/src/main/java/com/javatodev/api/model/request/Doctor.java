package com.javatodev.api.model.request;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Doctor")
@Data
public class Doctor {

    @Id
    private String id;
    private String firstName;
    private String lastName;
    private String email;
    private String address;
    private String img;
    private String phone;
    private String gender;
    private String dob;
    private String biography;
    private String clinicName;
    private String clinicAddress;
    private String clinicImages;
    private String city;
    private String state;
    private String country;
    private String postalCode;
    private String price;
    private String services;
    private String specialization;
    private String degree;
    private String college;
    private String completionYear;
    private String experience;
    private String designation;
    private String award;
    private String awardYear;
    private String registration;
    private String year;
    private String experienceHospitalName;
    private String expericenceStart;
    private String expericenceEnd;
    private boolean verified;

    // Getters and setters
}

