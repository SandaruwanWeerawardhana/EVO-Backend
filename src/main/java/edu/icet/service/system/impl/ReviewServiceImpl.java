package edu.icet.service.system.impl;

import edu.icet.dto.system.Review;
import edu.icet.entity.system.ReviewEntity;
import edu.icet.repository.system.ReviewRepository;
import edu.icet.service.system.QuickReplyService;
import edu.icet.service.system.ReviewService;
import edu.icet.util.RatingType;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ReviewServiceImpl implements ReviewService {
    final ReviewRepository repository;
    final ModelMapper mapper;
    final QuickReplyService service;

    @Override
    public Review addReview(Review review) {
        if (service.filterProfanity(review.getReviewText())){
            return mapper.map(repository.save(new ModelMapper()
                    .map(review, ReviewEntity.class)),Review.class);
        }else {
            return null;
        }

    }

    @Override
    public Review updateByReview(Review review) {
        if (service.filterProfanity(review.getReviewText())){
            return mapper.map(repository.save(mapper
                    .map(review, ReviewEntity.class)),Review.class);
        }else {
            return null;
        }
    }

    @Override
    public List<Review> getAll() {
        if (!repository.findAll().isEmpty()){
            return repository.findAll().stream().map(reviewEntity ->
                    mapper.map(reviewEntity,Review.class)
            ).toList();
        }else {
            return Collections.emptyList();
        }
    }

    @Override
    public boolean deleteByReview(Long id) {
        boolean isExistId = repository.existsById(id);
        if (isExistId){
            repository.deleteById(id);
            return true;
        }else {
            return false;
        }
    }

    @Override
    public List<Review> getReviewsBySupplierId(Long supplierId) {
        return repository.findBySupplierId(supplierId).stream().map(reviewEntity ->
                mapper.map(reviewEntity,Review.class)).toList();
    }

    @Override
    public List<Review> getReviewsByCustomerId(Long customerId) {
        return repository.findByCustomerId(customerId).stream().map(reviewEntity ->
                mapper.map(reviewEntity,Review.class)).toList();
    }

    @Override
    public List<Review> getReviewsByDate(LocalDate date) {
        return repository.findByDate(date).stream().map(reviewEntity -> mapper
                .map(reviewEntity,Review.class)).toList();
    }

    @Override
    public List<Review> getReviewsByRateType(RatingType type) {
        return repository.findByRatingType(type).stream().map(reviewEntity -> mapper
                .map(reviewEntity,Review.class)).toList();
    }
}
