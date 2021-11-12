package com.mvorodeveloper.spring5webapplication.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mvorodeveloper.spring5webapplication.repositories.BookRepository;

/**
 * Spring MVC Controller for Books
 */
@Controller
public class BookController {

    private final BookRepository bookRepository;

    // Dependency Injection
    public BookController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    /**
     * Associate path "/books" with this controller's method
     * @param model the model that is going to be returned to the View. We want a Model that has the list of all the Books
     * @return data from Controller to View. The data here are all the Books returned from the database
     */
    @RequestMapping("/books")
    public String getBooks(Model model) {
        // Enhancing the Model with an attribute with a list of all the Books we have in the DB
        model.addAttribute("books", bookRepository.findAll());

        // Return the View name
        return "books";
    }
}
