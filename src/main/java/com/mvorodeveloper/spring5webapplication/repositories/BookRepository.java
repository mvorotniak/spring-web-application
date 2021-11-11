package com.mvorodeveloper.spring5webapplication.repositories;

import org.springframework.data.repository.CrudRepository;

import com.mvorodeveloper.spring5webapplication.domain.Book;

public interface BookRepository extends CrudRepository<Book, Long> {
}
