package com.mvorodeveloper.spring5webapplication.domain;

import java.util.Set;

public class Book {

    private String name;
    private int numOfPages;
    private Set<Author> authors;

    public Book() {
    }

    public Book(String name, int numOfPages, Set<Author> authors) {
        this.name = name;
        this.numOfPages = numOfPages;
        this.authors = authors;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumOfPages() {
        return numOfPages;
    }

    public void setNumOfPages(int numOfPages) {
        this.numOfPages = numOfPages;
    }

    public Set<Author> getAuthors() {
        return authors;
    }

    public void setAuthors(Set<Author> authors) {
        this.authors = authors;
    }
}
