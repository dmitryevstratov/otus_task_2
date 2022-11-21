package com.otus.task2.mapper;

import com.otus.task2.model.entity.Genre;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class GenreRepositoryMapper implements RowMapper<Genre> {

    @Override
    public Genre mapRow(ResultSet rs, int rowNum) throws SQLException {
        Genre genre = new Genre();
        genre.setId((long) rs.getInt("id"));
        genre.setName(rs.getString("name"));
        return genre;
    }

}
