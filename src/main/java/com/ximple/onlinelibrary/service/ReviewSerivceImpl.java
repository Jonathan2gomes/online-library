package com.ximple.onlinelibrary.service;

import com.ximple.onlinelibrary.CacheUtils;
import com.ximple.onlinelibrary.dto.ReviewDto;
import com.ximple.onlinelibrary.exception.NotFoundException;
import com.ximple.onlinelibrary.mapper.ReviewMapper;
import com.ximple.onlinelibrary.repository.ReviewRepository;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class ReviewSerivceImpl implements ReviewService {

    private final ReviewRepository reviewRepository;
    private final BookService bookService;
    private final CacheUtils cacheUtils;
    private final ReviewMapper reviewMapper;


    public ReviewSerivceImpl(ReviewRepository reviewRepository, BookService bookService, CacheUtils cacheUtils, ReviewMapper reviewMapper) {
        this.reviewRepository = reviewRepository;
        this.bookService = bookService;
        this.cacheUtils = cacheUtils;
        this.reviewMapper = reviewMapper;
    }

    @Override
    @Transactional
    public void addReview(ReviewDto review, Long bookId) {
        cacheUtils.clearCache("reviews");
        bookService.findById(bookId);
        reviewRepository.save(reviewMapper.toEntity(review, bookId));
        log.info("Review added successfully");
    }

    @Override
    @Cacheable(value = "reviews")
    public List<ReviewDto> getReview(Long bookId, boolean noCache) {
        if (noCache) cacheUtils.clearCache("reviews");
        if (bookService.findById(bookId) == null) throw new NotFoundException("Book not found");
        return reviewMapper.toDtoList(reviewRepository.findAllByBookId(bookId));
    }
}
