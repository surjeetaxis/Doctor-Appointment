package com.javatodev.api.service;

import com.javatodev.api.model.request.ContactMessage;
import com.javatodev.api.repository.ContactMessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ContactMessageService {

    private final ContactMessageRepository contactMessageRepository;

    @Autowired
    public ContactMessageService(ContactMessageRepository contactMessageRepository) {
        this.contactMessageRepository = contactMessageRepository;
    }

    public ContactMessage saveContactMessage(ContactMessage message) {
        return contactMessageRepository.save(message);
    }
}
