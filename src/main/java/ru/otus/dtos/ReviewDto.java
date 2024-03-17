package ru.otus.dtos;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.Date;

@Data
public class ReviewDto {
    @NotNull(message = "Review ID cannot be empty")
    private Long id;
    @NotNull(message = "Book ID cannot be empty")
    private Long bookId;
    private Date reviewDate;
    private String userName;
    private Integer score;
    private String text;
}