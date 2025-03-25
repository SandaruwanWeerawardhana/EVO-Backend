package edu.icet.service.system.impl;

import edu.icet.dto.system.Review;
import edu.icet.service.system.ReviewService;
import edu.icet.util.RatingType;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
@Service
public class ReviewServiceImpl implements ReviewService {

    @Override
    public Review addReview(Review review) {
        return null;
    }

    @Override
    public Review getReviewSupplierId(Long id) {
        return null;
    }

    @Override
    public boolean updateByReview(Long id, Review review) {
        return false;
    }

    @Override
    public List<Review> getAll() {
        return List.of();
    }

    @Override
    public boolean deleteByReview(Long id) {
        return false;
    }

    @Override
    public Map<String, Long> getBySummaryFilterReview(Long id) {
        return Map.of();
    }

    @Override
    public List<Review> getReviewsBySupplierId(Long supplierId) {
        return List.of();
    }

    @Override
    public List<Review> getReviewsByCustomerId(Long customerId) {
        return List.of();
    }

    @Override
    public List<Review> getReviewsByDate(LocalDate date) {
        return List.of();
    }

    @Override
    public List<Review> getReviewsByRateType(RatingType type) {
        return List.of();
    }
}
