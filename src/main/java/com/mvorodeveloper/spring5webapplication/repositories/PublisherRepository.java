package com.mvorodeveloper.spring5webapplication.repositories;

import org.springframework.data.repository.CrudRepository;

import com.mvorodeveloper.spring5webapplication.domain.Publisher;

public interface PublisherRepository extends CrudRepository<Publisher, Long> {
}
