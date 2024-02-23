package com.javatodev.api.model.request;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.time.LocalDateTime;

@Document(collection = "Blogs")
@Data
public class Blog {

    @Id
    private String id;
    private String title;
    private String description;
    private String img;
    private String userId;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    // Getters and setters
}
