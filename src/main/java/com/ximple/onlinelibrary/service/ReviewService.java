package com.ximple.onlinelibrary.service;

import com.ximple.onlinelibrary.dto.ReviewDto;
import com.ximple.onlinelibrary.model.Review;

import java.util.List;

public interface ReviewService {

    void addReview(ReviewDto review, Long bookId);
    List<ReviewDto> getReview(Long bookId, boolean noCache);

}
