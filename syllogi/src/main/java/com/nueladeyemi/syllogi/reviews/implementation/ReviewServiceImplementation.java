package com.nueladeyemi.syllogi.reviews.implementation;

import com.nueladeyemi.syllogi.reviews.Review;
import com.nueladeyemi.syllogi.reviews.ReviewRepository;
import com.nueladeyemi.syllogi.reviews.ReviewService;

import java.util.List;

public class ReviewServiceImplementation implements ReviewService {
   private ReviewRepository reviewRepository;

    public ReviewServiceImplementation(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }

    @Override
    public List<Review> getAllReviews(Long companyId) {
        return reviewRepository.findByCompanyId(companyId);
    }
}
