package com.mvorodeveloper.spring5webapplication.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mvorodeveloper.spring5webapplication.repositories.AuthorRepository;

/**
 * Spring MVC Controller for Authors
 */
@Controller
public class AuthorController {

    private final AuthorRepository authorRepository;

    // Dependency Injection
    public AuthorController(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    /**
     * Mapping for Authors. A Model is passed to the View with a list of all the Authors from the DB
     * @return identifier for the View - Thymeleaf template showing a list of all the Authors.
     */
    @RequestMapping("/authors")
    public String getAuthors(Model model) {
        model.addAttribute("authors", authorRepository.findAll());

        // Corresponds to the "resources/templates/authors/list.html" file
        return "authors/list";
    }
}
