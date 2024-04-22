package com.ximple.onlinelibrary.resource;

import com.ximple.onlinelibrary.dto.ReviewDto;
import com.ximple.onlinelibrary.service.ReviewService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("v1/review")
public class ReviewController {

    private final ReviewService reviewService;

    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    @GetMapping("{id}/{noCache}")
    public ResponseEntity<List<ReviewDto>> getReviewById(@PathVariable Long id, @PathVariable boolean noCache) {
        return ResponseEntity.ok(reviewService.getReview(id, noCache));
    }

    @PostMapping("{id}")
    public ResponseEntity<String> createReview(@PathVariable Long id, @RequestBody ReviewDto reviewDto) {
        reviewService.addReview(reviewDto, id);
        return ResponseEntity.ok("Review added successfully");
    }
}
