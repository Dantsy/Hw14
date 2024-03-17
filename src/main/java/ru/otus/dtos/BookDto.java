package ru.otus.dtos;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class BookDto {
    @NotNull(message = "Book ID cannot be empty")
    private Long id;
    @NotNull(message = "Book title cannot be empty")
    private String title;
}