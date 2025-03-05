package edu.icet.service;

import edu.icet.dto.Review;
import edu.icet.util.Rating;
import java.util.List;
import java.util.Map;

public interface ReviewService {
    List<Review> getAll();
    Review addReview(Review review);
    Review searchByIdReview(long id);
    void updateByReview(long id,Review review);
    void deleteByReview(long id);
    Map<String,Long>getBySummaryFilterReview(long id);
}
