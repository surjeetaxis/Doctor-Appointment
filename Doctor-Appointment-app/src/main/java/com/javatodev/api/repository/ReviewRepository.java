package com.javatodev.api.repository;

import com.javatodev.api.model.request.Review;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ReviewRepository extends MongoRepository<Review, String> {
}

