package edu.icet.service;

import edu.icet.dto.Review;
import java.util.List;
import java.util.Map;

public interface ReviewService {
    List<Review> getAll();
    Review addReview(Review review);
    Review searchByIdReview(long id);
    boolean updateByReview(long id,Review review);
    boolean deleteByReview(long id);
    Map<String,Long>getBySummaryFilterReview(long id);
}
