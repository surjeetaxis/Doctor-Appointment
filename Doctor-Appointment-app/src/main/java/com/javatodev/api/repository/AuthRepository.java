package com.javatodev.api.repository;

import com.javatodev.api.model.request.Auth;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface AuthRepository extends MongoRepository<Auth, String> {
    Auth findByEmail(String email);
}
