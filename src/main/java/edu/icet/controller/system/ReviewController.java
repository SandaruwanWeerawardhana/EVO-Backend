package edu.icet.controller.system;

import edu.icet.dto.system.Review;

import edu.icet.service.system.ReviewService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/review")
@CrossOrigin
@RequiredArgsConstructor

public class ReviewController {
    final ReviewService reviewService;

    @PostMapping("/addReview")
    public ResponseEntity<Review> addByReview(@Valid @RequestBody Review review) {

        Review savedReview = reviewService.addReview(review);
        return (savedReview != null)
                ? ResponseEntity.status(HttpStatus.CREATED).body(savedReview)
                : ResponseEntity.status(HttpStatus.BAD_REQUEST).build();

    }

    @GetMapping("/searchByReviewId/{id}")
    public ResponseEntity<Review> searchByReview(@PathVariable long id) {
        Review review = reviewService.searchByIdReview(id);
        if (review != null) {
            return new ResponseEntity<>(review, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

    }

    @PutMapping("/updateByReviewId/{id}")
    public ResponseEntity<String> updateByReview(@PathVariable long id, @RequestBody Review review) {

        if (reviewService.updateByReview(id, review)) {
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

    }

    @GetMapping("/getAll")
    public ResponseEntity<List<Review>> getAllByReview() {
        List<Review> reviews = reviewService.getAll();

        return reviews.isEmpty()
                ? ResponseEntity.status(HttpStatus.NO_CONTENT).build()
                : ResponseEntity.ok(reviews);
    }


    @DeleteMapping("/deleteByReviewId/{id}")
    public ResponseEntity<String> deleteByReview(@PathVariable long id) {
        boolean isDeleted = reviewService.deleteByReview(id);

        return isDeleted
                ? ResponseEntity.ok("Review deleted successfully!")
                : ResponseEntity.status(HttpStatus.NOT_FOUND).body("Review not found!");
    }


    @GetMapping("/getSummaryById/{id}")
    public ResponseEntity<Map<String, Long>> getSummaryFilterReview(@PathVariable long id) {
        Map<String, Long> summary = reviewService.getBySummaryFilterReview(id);

        return (summary != null && !summary.isEmpty())
                ? ResponseEntity.ok(summary)
                : ResponseEntity.status(HttpStatus.NOT_FOUND).body(Map.of("message", 0L));
    }


    @GetMapping("/SearchSupplier/{id}")
    public Review searchBySupliierID( @PathVariable long id) {
      return   reviewService.searchByIDSuplier(id);

    }
}