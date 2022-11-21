package com.otus.task2.service;

import com.otus.task2.mapper.BookMapper;
import com.otus.task2.model.dto.BookDto;
import com.otus.task2.repository.api.BookRepository;
import com.otus.task2.service.api.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;
    private final BookMapper bookMapper;

    @Autowired
    public BookServiceImpl(BookRepository bookRepository, BookMapper bookMapper) {
        this.bookRepository = bookRepository;
        this.bookMapper = bookMapper;
    }

    @Transactional
    @Override
    public int save(Long id, String name, String description, Long idAuthor, String genre) {
        return bookRepository.save(id, name, description, idAuthor, genre);
    }

    @Transactional
    @Override
    public void deleteById(Long id) {
        bookRepository.deleteById(id);
    }

    @Transactional(readOnly = true)
    @Override
    public BookDto getById(Long id) {
        return bookMapper.toBookDto(bookRepository.getById(id));
    }

    @Transactional(readOnly = true)
    @Override
    public List<BookDto> findAll() {
        return bookRepository.findAll().stream()
                .map(bookMapper::toBookDto)
                .collect(Collectors.toList());
    }
}
