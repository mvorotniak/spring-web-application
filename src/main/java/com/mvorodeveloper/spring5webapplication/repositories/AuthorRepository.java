package com.mvorodeveloper.spring5webapplication.repositories;

import org.springframework.data.repository.CrudRepository;

import com.mvorodeveloper.spring5webapplication.domain.Author;

public interface AuthorRepository extends CrudRepository<Author, Long> {
}
