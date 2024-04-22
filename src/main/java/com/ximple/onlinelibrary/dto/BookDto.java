package com.ximple.onlinelibrary.dto;


import java.io.Serializable;
import java.util.List;

public record BookDto(String title, String author, List<ReviewDto> reviews) implements Serializable {
}
