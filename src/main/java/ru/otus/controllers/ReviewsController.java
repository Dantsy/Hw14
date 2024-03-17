package ru.otus.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ru.otus.dtos.ReviewDto;
import ru.otus.dtos.requests.CreateOrUpdateReviewDtoRq;
import ru.otus.dtos.responses.CreateOrUpdateReviewDtoRs;
import ru.otus.mapper.DtoMapper;
import ru.otus.services.ReviewsService;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/reviews")
public class ReviewsController {

    private final ReviewsService reviewsService;
    private final DtoMapper mapper;

    @PostMapping
    public ResponseEntity<CreateOrUpdateReviewDtoRs> createNewReview(@RequestBody @Validated CreateOrUpdateReviewDtoRq review) {
        ReviewDto reviewDto = mapper.createOrUpdateReviewDtoRqToReviewDto(review);
        return ResponseEntity.ok(mapper.reviewDtoToCreateOrUpdateReviewDtoRs(reviewsService.addReview(reviewDto)));
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<CreateOrUpdateReviewDtoRs> updateExistingReview(@PathVariable(name = "id") Long id, @RequestBody @Validated CreateOrUpdateReviewDtoRq review) {
        ReviewDto reviewDto = mapper.createOrUpdateReviewDtoRqToReviewDto(review);
        reviewDto.setId(id);
        return ResponseEntity.ok(mapper.reviewDtoToCreateOrUpdateReviewDtoRs(reviewsService.updateReview(reviewDto)));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deleteReview(@PathVariable(name = "id") Long id) {
        reviewsService.deleteReviewById(id);
        return ResponseEntity.noContent().build();
    }
}