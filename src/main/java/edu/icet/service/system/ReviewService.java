package edu.icet.service.system;

import edu.icet.dto.system.Review;
import jakarta.validation.Valid;

import java.util.List;
import java.util.Map;

public interface ReviewService {
    Review addReview(@Valid Review review);

    Review searchByIdReview(long id);

    boolean updateByReview(long id, Review review);

    List<Review> getAll();

    boolean deleteByReview(long id);

    Map<String, Long> getBySummaryFilterReview(long id);

    Review searchByIDSuplier(long id);
}
