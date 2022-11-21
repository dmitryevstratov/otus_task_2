package com.otus.task2.repository.api;

import com.otus.task2.model.entity.Author;

import java.util.List;

public interface AuthorRepository {

    List<Author> findAll();

}
