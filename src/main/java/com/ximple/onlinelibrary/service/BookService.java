package com.ximple.onlinelibrary.service;

import com.ximple.onlinelibrary.dto.BookDto;
import com.ximple.onlinelibrary.dto.BookDtoInput;
import com.ximple.onlinelibrary.model.Book;

import java.util.List;

public interface BookService {

    BookDto findById(Long id);

    List<BookDto> findAll(boolean noCache);

    void save(BookDtoInput book);

    BookDto findByName(String name);
}
