package com.javatodev.api.repository;

import com.javatodev.api.model.request.Blog;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface BlogRepository extends MongoRepository<Blog, String> {
}
