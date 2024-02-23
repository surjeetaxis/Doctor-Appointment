package com.javatodev.api.controller;

import com.javatodev.api.model.request.Review;
import com.javatodev.api.model.response.Response;
import com.javatodev.api.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/review")
@CrossOrigin(origins = "http://localhost:3000")
public class ReviewController {

    private final ReviewService reviewService;

    @Autowired
    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    @GetMapping("/doctor-review/{id}")
    public Response getDoctorReviews(@PathVariable String id) {
        List<Review> reviews = reviewService.getAllReviews();
        return new Response(200, "Successfully Retrieve !!", true, reviews);
    }

    @GetMapping("/{id}")
    public Response getSingleReview(@PathVariable String id) {
        Optional<Review> review = reviewService.getReviewById(id);
        return new Response(200, "Successfully Retrieve !!", true, review.map(value -> new ResponseEntity<>(value, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND)));

    }

    @PostMapping("/")
    public Response createReview(@RequestBody Review review) {
        Review createdReview = reviewService.createReview(review);
        return new Response(200, "Successfully Retrieve !!", true, createdReview);
    }

    @GetMapping("")
    public Response getAllReview() {
        List<Review> reviews = reviewService.getAllReviews();
        return new Response(200, "Successfully Retrieve !!", true, reviews);
    }

    @DeleteMapping("/{id}")
    public Response deleteReview(@PathVariable String id) {
        reviewService.deleteReview(id);
        return new Response(200, "Successfully Retrieve !!", true, null);
    }

    @PatchMapping("/{id}")
    public Response updateReview(@PathVariable String id, @RequestBody Review review) {
        review.setId(id);
        Review updatedReview = reviewService.updateReview(review);
        return new Response(200, "Successfully Retrieve !!", true, updatedReview);
    }

    @PatchMapping("/{id}/reply")
    public Response replyReviewByDoctor(@PathVariable String id, @RequestBody String response) {
        Optional<Review> review = reviewService.getReviewById(id);
        return new Response(200, "Successfully Retrieve !!", true, review);

    }

}

