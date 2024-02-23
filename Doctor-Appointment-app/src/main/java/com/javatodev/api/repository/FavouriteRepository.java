package com.javatodev.api.repository;

import com.javatodev.api.model.request.Favourite;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface FavouriteRepository extends MongoRepository<Favourite, String> {
    List<Favourite> findByPatientId(String patientId);
}

