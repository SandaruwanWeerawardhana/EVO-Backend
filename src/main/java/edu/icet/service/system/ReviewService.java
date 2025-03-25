package edu.icet.service.system;

import edu.icet.dto.system.Review;
import edu.icet.util.RatingType;
import jakarta.validation.Valid;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

public interface ReviewService {
    Review addReview(Review review);

    Review getReviewSupplierId(Long id);

    boolean updateByReview(Long id, Review review);

    List<Review> getAll();

    boolean deleteByReview(Long id);

    Map<String, Long> getBySummaryFilterReview(Long id);

    List<Review> getReviewsBySupplierId(Long supplierId);

    List<Review> getReviewsByCustomerId(Long customerId);

    List<Review> getReviewsByDate(LocalDate date);

    List<Review> getReviewsByRateType(RatingType type);
}
