package com.otus.task2.mapper;

import com.otus.task2.model.dto.BookDto;
import com.otus.task2.model.entity.Book;
import org.springframework.stereotype.Component;

@Component
public class BookMapper {

    public BookDto toBookDto(Book book) {
        BookDto bookDto = new BookDto();
        bookDto.setId(book.getId());
        bookDto.setName(book.getName());
        bookDto.setDescription(book.getDescription());
        bookDto.setIdAuthor(book.getIdAuthor());
        return bookDto;
    }

}
