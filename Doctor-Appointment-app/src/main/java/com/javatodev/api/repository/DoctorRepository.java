package com.javatodev.api.repository;

import com.javatodev.api.model.request.Doctor;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface DoctorRepository extends MongoRepository<Doctor, String> {
}

