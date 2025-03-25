package edu.icet.service.system;

import edu.icet.dto.system.Review;
import jakarta.validation.Valid;

import java.util.List;
import java.util.Map;

public interface ReviewService {
    Review addReview(@Valid Review review);

    Review searchByIdReview(Long id);

    boolean updateByReview( Review review);

    List<Review> getAll();

    boolean deleteByReview(Long id);

    Map<String, Long> getBySummaryFilterReview(Long id);

    Review searchByIDSuplier(Long id);
}
