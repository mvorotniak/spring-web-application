package com.mvorodeveloper.spring5webapplication.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.mvorodeveloper.spring5webapplication.domain.Author;
import com.mvorodeveloper.spring5webapplication.domain.Book;
import com.mvorodeveloper.spring5webapplication.repositories.AuthorRepository;
import com.mvorodeveloper.spring5webapplication.repositories.BookRepository;

/**
 * Spring Data Initialization
 *
 * Spring will look at this instance and "run it" as it implements {@link CommandLineRunner}.
 * Spring should detect this class as it's marked as a Spring managed component with the {@link Component} annotation.
 */
@Component
public class BootStrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;

    // Dependency Injection
    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }

    @Override
    public void run(String... args) {
        // Creating some random Authors and Books
        Author robert = new Author("Robert", "Martin");
        Author eric = new Author("Eric", "Evans");

        Book cleanCode = new Book("Clean Code", 1309);
        Book ddd = new Book("Domain Driven Design", 2784);

        // Adding relations
        robert.getBooks().add(cleanCode);
        cleanCode.getAuthors().add(robert);

        eric.getBooks().add(ddd);
        ddd.getAuthors().add(eric);

        // Saving the Authors and Books
        authorRepository.save(robert);
        authorRepository.save(eric);

        bookRepository.save(cleanCode);
        bookRepository.save(ddd);

        // Printing the results
        System.out.println("[Bootstrap Data Initialization] Started in Bootstrap...");
        System.out.println("[Bootstrap Data Initialized] Number of Books in Repository: " + bookRepository.count());
    }
}
