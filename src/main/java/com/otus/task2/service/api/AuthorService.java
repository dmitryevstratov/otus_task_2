package com.otus.task2.service.api;

import com.otus.task2.model.dto.AuthorDto;
import com.otus.task2.model.dto.GenreDto;

import java.util.List;

public interface AuthorService {

    List<AuthorDto> getAllAuthor();

}
