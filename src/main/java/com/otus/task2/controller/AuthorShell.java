package com.otus.task2.controller;

import com.otus.task2.model.dto.AuthorDto;
import com.otus.task2.service.api.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;

import java.util.List;

@ShellComponent
public class AuthorShell {

    private final AuthorService authorService;

    @Autowired
    public AuthorShell(AuthorService authorService) {
        this.authorService = authorService;
    }

    @ShellMethod(key = "findAll-author", value = "Author find all")
    public List<AuthorDto> findAllAuthor() {
        return authorService.getAllAuthor();
    }

}
