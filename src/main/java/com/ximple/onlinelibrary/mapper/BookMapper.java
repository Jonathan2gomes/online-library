package com.ximple.onlinelibrary.mapper;

import com.ximple.onlinelibrary.dto.BookDto;
import com.ximple.onlinelibrary.dto.BookDtoInput;
import com.ximple.onlinelibrary.dto.ReviewDto;
import com.ximple.onlinelibrary.model.Book;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookMapper {

    public BookDto toDto(Book book) {
        return new BookDto(book.getTitle(), book.getAuthor(), book.getReviews().stream().map(r -> new ReviewDto(r.getReview())).toList());
    }

    public Book toEntity(BookDtoInput bookDto) {
        return new Book(bookDto.title(), bookDto.author());
    }

    public Book toEntity(BookDto bookDto) {
        return new Book(bookDto.title(), bookDto.author());
    }

    public List<BookDto> toDtoList(List<Book> books) {
        return books.stream().map(this::toDto).toList();
    }
}
