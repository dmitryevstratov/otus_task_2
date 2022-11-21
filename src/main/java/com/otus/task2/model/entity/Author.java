package com.otus.task2.model.entity;

import org.springframework.data.annotation.Id;

import java.util.List;

public class Author {

    @Id
    private Long id;

    private String firstName;

    private String lastName;

    private List<Book> books;

    public void setId(Long id) {
        this.id = id;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }
}
