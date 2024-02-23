package com.javatodev.api.controller;

import com.javatodev.api.model.request.ContactMessage;
import com.javatodev.api.service.ContactMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/contact")
@CrossOrigin(origins = "http://localhost:3000")
public class ContactController {

    private final ContactMessageService contactMessageService;

    @Autowired
    public ContactController(ContactMessageService contactMessageService) {
        this.contactMessageService = contactMessageService;
    }

    @PostMapping("/")
    public ResponseEntity<String> contactUs(@RequestBody ContactMessage message) {
        contactMessageService.saveContactMessage(message);
        return ResponseEntity.status(HttpStatus.CREATED).body("Message sent successfully!");
    }
}

