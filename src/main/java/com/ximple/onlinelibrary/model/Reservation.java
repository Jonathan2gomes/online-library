package com.ximple.onlinelibrary.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity(name = "reservation")
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "book_id")
    private Book book;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    public Reservation(User user, Book book) {
        this.user = user;
        this.book = book;
    }

    public Reservation() {
    }
}
