package com.javatodev.api.service;

import com.javatodev.api.model.request.Author;
import com.javatodev.api.repository.AuthorRepository;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class LibraryService {

    @Autowired
    AuthorRepository authorRepository;
    public String createAuthor (Author request) {
        com.javatodev.api.model.Author author = new com.javatodev.api.model.Author();
        BeanUtils.copyProperties(request, author);
        authorRepository.saveDocument(author);
//        return authorRepository.findAuthor();
        return "success";
    }
}
