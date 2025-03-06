package edu.icet.service.impl;

import edu.icet.dto.Review;
import edu.icet.service.ReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.*;


@Service
@RequiredArgsConstructor
public class ReviewServiceImpl implements ReviewService {


       List<Review> reviewList  = new ArrayList<>();


    @Override
    public List<Review> getAll() {
        return new ArrayList<>(reviewList);
    }

    @Override
    public Review addReview(Review review) {

     validateReview(review);
        reviewList.add(review);
         return review;

    }

    @Override
    public Review searchByIdReview(long id) {

        for (Review review : reviewList) {
            if (review.getReviewId() == id) {
                return review;
            }
        }
        return null;

    }

    @Override
    public boolean updateByReview(long id, Review review) {
        validateReview(review);
        for (int i = 0; i < reviewList.size(); i++) {
            if (reviewList.get(i).getReviewId() == id) {
                reviewList.set(i, review);
                return true;
            }
        }
        throw new NoSuchElementException("Review with ID " + id + " not found!");
    }

    @Override
    public boolean deleteByReview(long id) {
        boolean removed =  reviewList.remove(id);
            if (!removed) {
                throw new NoSuchElementException( id + " not found !!");
            }
        return removed;
    }

    @Override
    public Map<String, Long> getBySummaryFilterReview(long id) {

        List<Review> reviewList = getAll();


        Optional<Review> optionalReview = reviewList.stream()
                .filter(review -> review.getReviewId() == id)
                .findFirst();

        if (optionalReview.isEmpty()) {
            throw new NoSuchElementException("Review with ID " + id + " not found !!");
        }

        Review review = optionalReview.get();

        return Map.of(
                "id", review.getReviewId(),
                "rating", (long) (review.getRating().ordinal() + 1),
                "commentLength", (long) review.getComment().length()
        );
    }

    private void validateReview(Review review) {
        if (review == null) {
            throw new IllegalArgumentException("Review cannot be null");
        }

        if (review.getComment() == null || review.getComment().trim().isEmpty()) {
            throw new IllegalArgumentException("Comment cannot be empty");
        }
        if (review.getComment().length() > 500) {
            throw new IllegalArgumentException("Comment is too long (max 500 characters)");
        }
    }






}
