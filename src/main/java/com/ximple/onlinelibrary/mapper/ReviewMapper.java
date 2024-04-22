package com.ximple.onlinelibrary.mapper;

import com.ximple.onlinelibrary.dto.ReviewDto;
import com.ximple.onlinelibrary.model.Review;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewMapper {

    public ReviewDto toDto(Review review) {
        return new ReviewDto(review.getReview());
    }

    public Review toEntity(ReviewDto reviewDto, Long book) {
        return new Review(reviewDto.review(), book);
    }

    public List<ReviewDto> toDtoList(List<Review> reviews) {
        return reviews.stream().map(this::toDto).toList();
    }
}
