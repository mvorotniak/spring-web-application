package com.mvorodeveloper.spring5webapplication.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.mvorodeveloper.spring5webapplication.domain.Author;
import com.mvorodeveloper.spring5webapplication.domain.Book;
import com.mvorodeveloper.spring5webapplication.domain.Publisher;
import com.mvorodeveloper.spring5webapplication.repositories.AuthorRepository;
import com.mvorodeveloper.spring5webapplication.repositories.BookRepository;
import com.mvorodeveloper.spring5webapplication.repositories.PublisherRepository;

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
    private final PublisherRepository publisherRepository;

    // Dependency Injection
    public BootStrapData(
        AuthorRepository authorRepository,
        BookRepository bookRepository,
        PublisherRepository publisherRepository
    ) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) {
        System.out.println("[Bootstrap Data Initialization] Started in Bootstrap...");

        Publisher publisher = new Publisher("SFG Publishing", "Main Street", "Austin", "Texas", "3200");

        // The order in which we save the objects and implement a relationship matters.
        // Incorrect order of saving may lead to a TransientPropertyValueException
        publisherRepository.save(publisher);

        Author robert = new Author("Robert", "Martin");
        Book cleanCode = new Book("Clean Code", 1309);

        robert.getBooks().add(cleanCode);
        cleanCode.getAuthors().add(robert);
        cleanCode.setPublisher(publisher);
        publisher.getBooks().add(cleanCode);

        authorRepository.save(robert);
        bookRepository.save(cleanCode);
        publisherRepository.save(publisher);

        Author eric = new Author("Eric", "Evans");
        Book ddd = new Book("Domain Driven Design", 2784);

        eric.getBooks().add(ddd);
        ddd.getAuthors().add(eric);
        ddd.setPublisher(publisher);
        publisher.getBooks().add(ddd);

        authorRepository.save(eric);
        bookRepository.save(ddd);
        publisherRepository.save(publisher);

        // Printing the results
        System.out.println("[Bootstrap Data Initialized] Number of Books in Repository: " + bookRepository.count());
        System.out.println("[Bootstrap Data Initialized] Number of Publishers in Repository: " + publisherRepository.count());
        System.out.println("[Bootstrap Data Initialized] Number of Books for Publisher: " + publisher.getBooks().size());
    }
}
