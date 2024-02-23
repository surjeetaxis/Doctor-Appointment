package com.javatodev.api.model.request;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "ContactMessage")
public class ContactMessage {

    @Id
    private String id;
    private String name;
    private String email;
    private String subject;
    private String message;

    // Getters and setters
}

