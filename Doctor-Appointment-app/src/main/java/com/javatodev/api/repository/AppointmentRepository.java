package com.javatodev.api.repository;

import com.javatodev.api.model.request.Appointment;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface AppointmentRepository extends MongoRepository<Appointment, String> {
    // Define custom queries if needed
}
