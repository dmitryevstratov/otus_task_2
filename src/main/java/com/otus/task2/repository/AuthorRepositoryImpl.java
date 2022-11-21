package com.otus.task2.repository;

import com.otus.task2.mapper.AuthorRepositoryMapper;
import com.otus.task2.model.entity.Author;
import com.otus.task2.repository.api.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;

@Repository
public class AuthorRepositoryImpl implements AuthorRepository {

    private final DataSource dataSource;
    private final JdbcTemplate jdbcTemplate;
    private final AuthorRepositoryMapper mapper;

    @Autowired
    public AuthorRepositoryImpl(DataSource dataSource, AuthorRepositoryMapper mapper) {
        this.dataSource = dataSource;
        this.mapper = mapper;
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public List<Author> findAll() {
        return jdbcTemplate.query("SELECT * FROM Author", mapper);
    }

}
