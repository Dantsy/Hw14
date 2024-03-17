package ru.otus.dtos;

import jakarta.validation.constraints.NotNull;
import lombok.Data;
import ru.otus.entities.Genre;

@Data
public class DetailedBookDto {
    @NotNull(message = "Book ID cannot be empty")
    private Long id;
    @NotNull(message = "Book title cannot be empty")
    private String title;
    private Genre genre;
    private String authorName;
    private String description;
    private Float averageScore;
}