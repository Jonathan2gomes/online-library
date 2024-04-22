package com.ximple.onlinelibrary.service;

import com.ximple.onlinelibrary.CacheUtils;
import com.ximple.onlinelibrary.dto.BookDto;
import com.ximple.onlinelibrary.dto.BookDtoInput;
import com.ximple.onlinelibrary.exception.NotFoundException;
import com.ximple.onlinelibrary.mapper.BookMapper;
import com.ximple.onlinelibrary.repository.BookRepository;
import jakarta.transaction.Transactional;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;
    private final CacheUtils cacheUtils;
    private final BookMapper bookMapper;

    public BookServiceImpl(BookRepository bookRepository, CacheUtils cacheUtils, BookMapper bookMapper) {
        this.bookRepository = bookRepository;
        this.cacheUtils = cacheUtils;
        this.bookMapper = bookMapper;
    }

    @Override
    public BookDto findById(Long id) {
        return bookMapper.toDto(bookRepository.findById(id).orElseThrow(() -> new NotFoundException("Book not found")));
    }

    @Override
    @Cacheable("books")
    public List<BookDto> findAll(boolean noCache) {
        if (noCache) cacheUtils.clearCache("books");

        return bookMapper.toDtoList(bookRepository.findAll());
    }

    @Override
    @Transactional
    public void save(BookDtoInput book) {
        cacheUtils.clearCache("books");
        bookRepository.save(bookMapper.toEntity(book));
    }

    @Override
    public BookDto findByName(String title) {
        return bookMapper.toDto(bookRepository.findByTitle(title).orElseThrow(() -> new NotFoundException("Book not found")));
    }
}
