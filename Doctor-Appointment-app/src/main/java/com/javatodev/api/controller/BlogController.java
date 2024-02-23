package com.javatodev.api.controller;

import com.javatodev.api.model.request.Blog;
import com.javatodev.api.model.response.Response;
import com.javatodev.api.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/blogs")
@CrossOrigin(origins = "http://localhost:3000")
public class BlogController {

    private final BlogService blogService;

    @Autowired
    public BlogController(BlogService blogService) {
        this.blogService = blogService;
    }

    @GetMapping
    public Response getAllBlogs() {
        List<Blog> blogs = blogService.getAllBlogs();
        return new Response(200, "Successfully Retrieve !!", true, blogs);
    }

    @GetMapping("/{id}")
    public Response getBlogById(@PathVariable String id) {
        Optional<Blog> blog = blogService.getBlogById(id);
        return new Response(200, "Successfully Retrieve !!", true, blog.map(value -> new ResponseEntity<>(value, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND)));

    }

    @PostMapping
    public Response createBlog(@RequestBody Blog blog) {
        Blog createdBlog = blogService.createBlog(blog);
        return new Response(200, "Successfully Retrieve !!", true, createdBlog);
    }

    @PutMapping("/{id}")
    public Response updateBlog(@PathVariable String id, @RequestBody Blog blog) {
        Blog updatedBlog = blogService.updateBlog(id, blog);
        return new Response(200, "Successfully Retrieve !!", true, updatedBlog);
    }

    @DeleteMapping("/{id}")
    public Response deleteBlog(@PathVariable String id) {
        blogService.deleteBlog(id);
        return new Response(200, "Successfully Retrieve !!", true, null);
    }
}

