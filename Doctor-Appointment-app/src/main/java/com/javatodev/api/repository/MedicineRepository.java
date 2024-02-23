package com.javatodev.api.repository;

import com.javatodev.api.model.request.Auth;
import com.javatodev.api.model.request.Medicine;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface MedicineRepository extends MongoRepository<Medicine, String> {
    Medicine findByMedicine(String medicine);
}
