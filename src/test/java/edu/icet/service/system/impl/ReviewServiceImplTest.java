package edu.icet.service.system.impl;

import edu.icet.Main;
import edu.icet.dto.system.Review;
import edu.icet.entity.system.ReviewEntity;

import edu.icet.repository.system.ReviewRepository;
import edu.icet.service.system.QuickReplyService;
import edu.icet.util.RatingType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@SpringBootTest(classes = Main.class)
class ReviewServiceImplTest {

    //use new Model Mapper in serviceImpl to pass the test cases...

    @Mock
    private ReviewRepository repository;

    @Mock
    QuickReplyService quickReplyService;

    @InjectMocks
    ReviewServiceImpl service;

    Review review1;
    Review review2;

    ReviewEntity reviewEntity1;
    ReviewEntity reviewEntity2;

    @BeforeEach
    void setup() {

        review1 = new Review(1L, 1L, 1L, LocalDate.now(), "Good", RatingType.ONE);
        review2 = new Review(2L, 2L, 2L, LocalDate.now(), "Good", RatingType.TWO);

        reviewEntity1 = new ReviewEntity(1L, 1L, 1L, LocalDate.now(), "Good", RatingType.ONE);
        reviewEntity2 = new ReviewEntity(2L, 2L, 2L, LocalDate.now(), "Good", RatingType.ONE);

    }

    @Test
    void getAllTest() {
        when(repository.findAll()).thenReturn(Arrays.asList(reviewEntity1, reviewEntity2));

        List<Review> result = service.getAll();

        assertEquals(2, result.size());

        assertNotNull(result);
        assertEquals(review1.getReviewId(), result.get(0).getReviewId());
        assertEquals(review2.getReviewId(), result.get(1).getReviewId());
    }
    @Test
    void addReviewTest(){
        when(quickReplyService.filterProfanity(review1.getReviewText())).thenReturn(false);
        when(repository.save(reviewEntity1)).thenReturn(reviewEntity1);

        Review result = service.addReview(review1);

        assertNotNull(result);
        assertEquals(review1.getReviewId(), result.getReviewId());
    }

    @Test
    void updateReviewTest(){
        when(quickReplyService.filterProfanity(review1.getReviewText())).thenReturn(false);
        when(repository.save(reviewEntity1)).thenReturn(reviewEntity1);

        Review result = service.updateByReview(review1);

        assertNotNull(result);
        assertEquals(review1.getReviewId(), result.getReviewId());
    }
    @Test
    void deleteReviewById(){
        when(repository.existsById(1L)).thenReturn(true);
        doNothing().when(repository).deleteById(1L);

        boolean result = service.deleteByReview(1L);

        assertTrue(result);
    }
    @Test
    void getReviewBySupplierId(){
        when(repository.findBySupplierId(1L)).thenReturn(Arrays.asList(reviewEntity1,reviewEntity2));

        List<Review> result = service.getReviewsBySupplierId(1L);

        assertNotNull(result);
        assertEquals(2, result.size());
        assertEquals(reviewEntity1.getReviewId(),result.get(0).getReviewId());
    }
    @Test
    void getReviewsByCustomerId(){
        when(repository.findByCustomerId(1L)).thenReturn(Arrays.asList(reviewEntity1,reviewEntity2));

        List<Review> result = service.getReviewsByCustomerId(1L);

        assertNotNull(result);
        assertEquals(2, result.size());
        assertEquals(reviewEntity1.getReviewId(),result.get(0).getReviewId());
    }
    @Test
    void getReviewsByDate(){
        when(repository.findByDate(LocalDate.now())).thenReturn(Arrays.asList(reviewEntity1,reviewEntity2));
        List<Review> result = service.getReviewsByDate(LocalDate.now());
        assertEquals(2,result.size());
    }
    @Test
    void getReviewByRateType(){
        when(repository.findAll()).thenReturn(Arrays.asList(reviewEntity1,reviewEntity2));
        List<Review> result = service.getReviewsByRateType(RatingType.ONE);
        assertEquals(2,result.size());

    }
    @Test
    void getSearchByReviewID(){
        when(repository.findById(1l)).thenReturn(Optional.ofNullable(reviewEntity1));
        Review result = service.SearchByReviewID(1L);
        assertEquals(reviewEntity1.getReviewText(),result.getReviewText());
    }

}