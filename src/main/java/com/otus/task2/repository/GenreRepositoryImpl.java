package com.otus.task2.repository;

import com.otus.task2.mapper.GenreRepositoryMapper;
import com.otus.task2.model.entity.Genre;
import com.otus.task2.repository.api.GenreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;

@Repository
public class GenreRepositoryImpl implements GenreRepository {

    private final DataSource dataSource;
    private final JdbcTemplate jdbcTemplate;
    private final GenreRepositoryMapper mapper;

    @Autowired
    public GenreRepositoryImpl(DataSource dataSource, GenreRepositoryMapper mapper) {
        this.dataSource = dataSource;
        this.mapper = mapper;
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public List<Genre> findAll() {
        return jdbcTemplate.query("SELECT * FROM GENRE", mapper);
    }

}
