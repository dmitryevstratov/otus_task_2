package com.otus.task2.repository.api;

import com.otus.task2.model.entity.Book;

import java.util.List;

public interface BookRepository {

    int save(Long id, String name, String description, Long idAuthor, String genre);

    void deleteById(Long id);

    Book getById(Long id);

    List<Book> findAll();

}
