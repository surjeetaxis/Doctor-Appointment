package com.javatodev.api.repository;

import com.javatodev.api.model.request.Patient;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PatientRepository extends MongoRepository<Patient, String> {
}

