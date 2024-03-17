package ru.otus.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ru.otus.dtos.BookDto;
import ru.otus.dtos.CategoryDto;
import ru.otus.dtos.ReviewDto;
import ru.otus.dtos.requests.CreateOrUpdateReviewDtoRq;
import ru.otus.dtos.responses.CreateOrUpdateReviewDtoRs;
import ru.otus.entities.Book;
import ru.otus.entities.Category;
import ru.otus.entities.Review;

@Mapper(componentModel = "spring")
public interface DtoMapper {

    CategoryDto categoryToCategoryDto(Category category);

    BookDto bookToBookDto(Book book);

    ReviewDto ReviewToReviewDto(Review review);

    Review ReviewDtoToReview(ReviewDto review);

    CreateOrUpdateReviewDtoRs reviewDtoToCreateOrUpdateReviewDtoRs(ReviewDto review);

    @Mapping(target = "id", ignore = true)
    ReviewDto createOrUpdateReviewDtoRqToReviewDto(CreateOrUpdateReviewDtoRq createOrUpdateReviewDtoRq);
}
