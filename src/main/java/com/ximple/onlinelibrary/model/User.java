package com.ximple.onlinelibrary.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Data
@Entity(name = "user_library")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    @NotNull
    private String name;

    @Column
    @NotNull
    private String registration;

    @Column
    @NotNull
    private String email;

    public User(String name, String registration, String email) {
        this.name = name;
        this.registration = registration;
        this.email = email;
    }

    public User() {

    }
}

