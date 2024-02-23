package com.javatodev.api.service;

import com.javatodev.api.model.request.Blog;
import com.javatodev.api.repository.BlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class BlogService {

    private final BlogRepository blogRepository;

    @Autowired
    public BlogService(BlogRepository blogRepository) {
        this.blogRepository = blogRepository;
    }

    public List<Blog> getAllBlogs() {
        return blogRepository.findAll();
    }

    public Optional<Blog> getBlogById(String id) {
        return blogRepository.findById(id);
    }

    public Blog createBlog(Blog blog) {
        blog.setCreatedAt(LocalDateTime.now());
        blog.setUpdatedAt(LocalDateTime.now());
        return blogRepository.save(blog);
    }

    public void deleteBlog(String id) {
        blogRepository.deleteById(id);
    }

    public Blog updateBlog(String id, Blog newBlog) {
        newBlog.setId(id);
        newBlog.setUpdatedAt(LocalDateTime.now());
        return blogRepository.save(newBlog);
    }
}

