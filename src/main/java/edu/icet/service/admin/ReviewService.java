package edu.icet.service.admin;

import edu.icet.dto.Review;
import edu.icet.dto.Supplier;

import java.util.List;
import java.util.Map;

public interface ReviewService {
    List<Review> getAll();
    Review addReview(Review review);
    Review searchByIdReview(Long id);
    boolean updateByReview(Long id,Review review);
    boolean deleteByReview(Long id);
    Map<String,Long>getBySummaryFilterReview(Long id);
    Review searchByIDSuplier(Long id);
}
