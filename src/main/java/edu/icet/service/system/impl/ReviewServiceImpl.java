package edu.icet.service.system.impl;

import edu.icet.dto.system.Review;
import edu.icet.service.system.ReviewService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
@Service
public class ReviewServiceImpl implements ReviewService {
    @Override
    public Review addReview(Review review) {
        return null;
    }

    @Override
    public Review searchByIdReview(Long id) {
        return null;
    }

    @Override
    public boolean updateByReview( Review review) {
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
    public Review searchByIDSuplier(Long id) {
        return null;
    }
}
