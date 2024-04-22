package com.ximple.onlinelibrary.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.List;

@Data
@Entity(name = "book")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    @NotNull
    private String title;

    @Column
    @NotNull
    private String author;

    @OneToMany(mappedBy = "book")
    private List<Review> reviews;

    public Book(String author, String title) {
        this.author = author;
        this.title = title;
    }

    public Book() {
    }
}
