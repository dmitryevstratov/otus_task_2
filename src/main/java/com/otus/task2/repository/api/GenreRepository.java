package com.otus.task2.repository.api;

import com.otus.task2.model.entity.Genre;

import java.util.List;

public interface GenreRepository {

    List<Genre> findAll();

}
