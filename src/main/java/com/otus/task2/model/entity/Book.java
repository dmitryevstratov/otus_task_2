package com.otus.task2.model.entity;

import org.springframework.data.annotation.Id;

import java.util.List;

public class Book {

    @Id
    private Long id;

    private String name;

    private String description;

    private List<Genre> genre;

    private Long idAuthor;

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public Long getIdAuthor() {
        return idAuthor;
    }

    public void setIdAuthor(Long idAuthor) {
        this.idAuthor = idAuthor;
    }
}
