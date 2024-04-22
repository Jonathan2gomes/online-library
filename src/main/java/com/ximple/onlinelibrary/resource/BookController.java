package com.ximple.onlinelibrary.resource;

import com.ximple.onlinelibrary.dto.BookDto;
import com.ximple.onlinelibrary.dto.BookDtoInput;
import com.ximple.onlinelibrary.service.BookService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("v1/books")
public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("no-cache")
    public ResponseEntity<List<BookDto>> getBooks(@RequestParam("no-cache") boolean noCache) {
        return ResponseEntity.ok().body(bookService.findAll(noCache));
    }

    @GetMapping("/{id}")
    public ResponseEntity<BookDto> getBookById(@PathVariable Long id) {
        return ResponseEntity.ok().body(bookService.findById(id));
    }

    @GetMapping("/{name}")
    public ResponseEntity<BookDto> getBookByName(@PathVariable String name) {
        return ResponseEntity.ok().body(bookService.findByName(name));
    }

    @PostMapping
    public ResponseEntity<String> createBook(@RequestBody BookDtoInput bookDto) {
        bookService.save(bookDto);
        return ResponseEntity.status(HttpStatus.CREATED).body("Book created successfully");
    }
}
