package com.javatodev.api.repository;

import com.javatodev.api.model.request.DoctorTimeSlot;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface DoctorTimeSlotRepository extends MongoRepository<DoctorTimeSlot, String> {
}
