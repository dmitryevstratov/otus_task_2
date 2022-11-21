package com.otus.task2.controller;

import com.otus.task2.model.dto.BookDto;
import com.otus.task2.service.api.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;

import java.util.List;

@ShellComponent
public class BookShell {

    private final BookService bookService;

    @Autowired
    public BookShell(BookService bookService) {
        this.bookService = bookService;
    }

    @ShellMethod(key = "R", value = "Book find all")
    public List<BookDto> findAllBook() {
        return bookService.findAll();
    }

    @ShellMethod(key = "delete-book", value = "Delete book by id")
    public void deleteBookById(Long id) {
        bookService.deleteById(id);
    }

    @ShellMethod(key = "ID", value = "Get book by id")
    public BookDto getBookById(Long id) {
        return bookService.getById(id);
    }

    @ShellMethod(key = "save-book", value = "Save book")
    public int saveBook(Long id, String name, String description, Long idAuthor, String genre) {
        return bookService.save(id, name, description, idAuthor, genre);
    }
}
