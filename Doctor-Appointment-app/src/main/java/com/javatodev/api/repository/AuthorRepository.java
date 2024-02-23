package com.javatodev.api.repository;

import com.javatodev.api.model.Author;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Repository;
import org.springframework.util.CollectionUtils;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.*;

@Repository
public class AuthorRepository{

    @Autowired
    private MongoTemplate mongoTemplate;
    private LocalDateTime lastUpTime;
    public <T> void save(T t) {
        mongoTemplate.save(t);
    }

    public List<Author> findAuthor() {
        List<Author> authorList = mongoTemplate.findAll(Author.class);
        if(CollectionUtils.isEmpty(authorList)) return new ArrayList<>();
        return authorList;
    }

    private Queue<Author> pendingRecords = new LinkedList<>();

    @CircuitBreaker(name = "mongo")
    public void process() {
        mongoTemplate.findAll(Author.class); // process your query here
    }
    private boolean isMongoDBUp() {
        try {
            process();
            lastUpTime = LocalDateTime.now();
            return true;
        } catch (Exception e) {
            if (lastUpTime != null && Duration.between(lastUpTime, LocalDateTime.now()).toMinutes() >= 5) {
                System.out.println("MongoDB is still down after 5 minutes. Cannot process pending records.");
                // MongoDB has been down for more than 5 minutes, trigger an alert
//                triggerAlert();
            }
            return false;
        }
    }
//    @Scheduled(fixedDelay=5000)
//    public void processPendingRecords() {
//        System.out.println("scheduled running...........");
//        if (!isMongoDBUp()) {
//            System.out.println("MongoDB is down. Cannot process pending records.");
//            return;
//        }
//        while (!pendingRecords.isEmpty()) {
//            System.out.println("inside while..........."+pendingRecords.size());
//            Author record = pendingRecords.poll();
//            if (record != null) {
//                mongoTemplate.save(record); // Save the record to MongoDB
//                System.out.println("Processed pending record: " + record);
//            }
//        }
//    }
    public void saveDocument(Author document) {
        try {
            process();
            mongoTemplate.save(document); // Save the document to MongoDB
            System.out.println("Saved document: " + document.toString());
        } catch (Exception ex){
            pendingRecords.offer(document); // MongoDB is down, hold the record
            System.out.println("MongoDB is down. Holding record: " + document.toString());
        }
    }
}

