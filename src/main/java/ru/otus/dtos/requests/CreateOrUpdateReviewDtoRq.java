package ru.otus.dtos.requests;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.Date;

@Data
public class CreateOrUpdateReviewDtoRq {

    @NotNull(message = "Book ID cannot be empty")
    private Long bookId;

    private Date reviewDate;

    @NotBlank(message = "Username cannot be empty")
    private String userName;

    @NotNull(message = "The rating cannot be empty")
    @Min(value = 0, message = "The score must be at least 0")
    @Max(value = 10, message = "The score should be no more than 10")
    private Integer score;

    private String text;
}