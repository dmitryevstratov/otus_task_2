package com.otus.task2.mapper;

import com.otus.task2.model.entity.Book;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class BookRepositoryMapper implements RowMapper<Book> {

    @Override
    public Book mapRow(ResultSet rs, int rowNum) throws SQLException {
        Book book = new Book();

        book.setId((long) rs.getInt("id"));
        book.setName(rs.getString("name"));
        book.setDescription(rs.getString("description"));
        book.setIdAuthor((long) rs.getInt("id_author"));
        return book;
    }
}
