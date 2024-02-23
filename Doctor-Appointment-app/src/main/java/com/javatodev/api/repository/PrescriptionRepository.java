package com.javatodev.api.repository;

import com.javatodev.api.model.request.Medicine;
import com.javatodev.api.model.request.Prescription;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PrescriptionRepository extends MongoRepository<Prescription, String> {
}
