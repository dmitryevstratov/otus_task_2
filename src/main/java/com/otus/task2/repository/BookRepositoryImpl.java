package com.otus.task2.repository;

import com.otus.task2.mapper.AuthorRepositoryMapper;
import com.otus.task2.mapper.BookRepositoryMapper;
import com.otus.task2.mapper.GenreRepositoryMapper;
import com.otus.task2.model.entity.Author;
import com.otus.task2.model.entity.Book;
import com.otus.task2.model.entity.Genre;
import com.otus.task2.repository.api.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.util.CollectionUtils;

import javax.sql.DataSource;
import java.util.List;

@Repository
public class BookRepositoryImpl implements BookRepository {

    private final DataSource dataSource;
    private final JdbcTemplate jdbcTemplate;
    private final BookRepositoryMapper bookRepositoryMapper;
    private final GenreRepositoryMapper genreRepositoryMapper;
    private final AuthorRepositoryMapper authorRepositoryMapper;

    @Autowired
    public BookRepositoryImpl(DataSource dataSource, BookRepositoryMapper bookRepositoryMapper, GenreRepositoryMapper genreRepositoryMapper, AuthorRepositoryMapper authorRepositoryMapper) {
        this.dataSource = dataSource;
        this.jdbcTemplate = new JdbcTemplate(dataSource);
        this.bookRepositoryMapper = bookRepositoryMapper;
        this.genreRepositoryMapper = genreRepositoryMapper;
        this.authorRepositoryMapper = authorRepositoryMapper;
    }

    @Override
    public int save(Long id, String name, String description, Long idAuthor, String genre) {
        List<Genre> genres = jdbcTemplate.query("SELECT * FROM GENRE WHERE NAME=?", new Object[]{genre}, genreRepositoryMapper);
        List<Author> authors = jdbcTemplate.query("SELECT * FROM AUTHOR WHERE ID=?", new Object[]{idAuthor}, authorRepositoryMapper);

        if (!CollectionUtils.isEmpty(genres) && !CollectionUtils.isEmpty(authors)) {
            int update = jdbcTemplate.update("INSERT INTO BOOK(id, name, description, id_author) VALUES (?, ?, ?, ?)", id, name, description, idAuthor);
            jdbcTemplate.update("INSERT INTO BOOK_GENRE(book_id, genre_id) VALUES (?, ?)", id, genres.get(0).getId());
            return update;
        }

        return 0;
    }

    @Override
    public void deleteById(Long id) {
        jdbcTemplate.update("DELETE FROM BOOK_GENRE WHERE BOOK_ID=?", id);
        jdbcTemplate.update("DELETE FROM BOOK WHERE id=?", id);
    }

    @Override
    public Book getById(Long id) {
        return jdbcTemplate.query("SELECT * FROM BOOK WHERE id=?", new Object[]{id}, bookRepositoryMapper).get(0);
    }

    @Override
    public List<Book> findAll() {
        return jdbcTemplate.query("SELECT * FROM BOOK", bookRepositoryMapper);
    }

}
