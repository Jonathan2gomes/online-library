package com.ximple.onlinelibrary.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
@Entity(name = "review")
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    @NotNull
    private String review;

    @ManyToOne
    @JoinColumn(name = "book_id")
    private Book book;

    public Review(String review, Long bookId) {
        this.review = review;
        this.book = new Book();
        this.book.setId(bookId);
    }

    public Review() {
    }

    public Review(String review) {
    }
}
