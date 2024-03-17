package ru.otus.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.otus.dtos.ReviewDto;
import ru.otus.exceptions.ResourceNotFoundException;
import ru.otus.mapper.DtoMapper;
import ru.otus.repositories.BooksRepository;
import ru.otus.repositories.ReviewsRepository;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class ReviewsService {

    private final ReviewsRepository reviewsRepository;
    private final BooksRepository booksRepository;
    private final DtoMapper mapper;

    public List<ReviewDto> getAllForBookId(Long bookId) {
        if (!booksRepository.existsById(bookId)) {
            throw new ResourceNotFoundException("Book with id %s not found".formatted(bookId));
        }
        return reviewsRepository.findAllByBookId(bookId).stream()
                .map(mapper::ReviewToReviewDto)
                .collect(Collectors.toList());
    }

    @Transactional
    public ReviewDto addReview(ReviewDto reviewDto) {
        if (!booksRepository.existsById(reviewDto.getBookId())) {
            throw new ResourceNotFoundException("Book with id %s not found".formatted(reviewDto.getBookId()));
        }
        return mapper.ReviewToReviewDto(reviewsRepository.save(mapper.ReviewDtoToReview(reviewDto)));
    }

    @Transactional
    public ReviewDto updateReview(ReviewDto reviewDto) {
        reviewsRepository.findById(reviewDto.getId()).orElseThrow(
                () -> new ResourceNotFoundException("Review with id %s not found".formatted(reviewDto.getId())));
        if (!booksRepository.existsById(reviewDto.getBookId())) {
            throw new ResourceNotFoundException("Book with id %s not found".formatted(reviewDto.getBookId()));
        }
        return mapper.ReviewToReviewDto(reviewsRepository.save(mapper.ReviewDtoToReview(reviewDto)));
    }

    @Transactional
    public void deleteReviewById(Long id) {
        reviewsRepository.deleteById(id);
    }
}