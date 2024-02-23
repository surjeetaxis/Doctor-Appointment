package com.javatodev.api.controller;

import com.javatodev.api.model.request.Author;
import com.javatodev.api.service.LibraryService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping(value = "/api/library")
@RequiredArgsConstructor
public class LibraryController {
    private final LibraryService libraryService;
    @PostMapping("/author")
    public ResponseEntity<String> createAuthor (@RequestBody Author request) {
        return ResponseEntity.ok(libraryService.createAuthor(request));
    }
}
