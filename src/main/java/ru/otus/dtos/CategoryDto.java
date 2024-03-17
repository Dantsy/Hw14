package ru.otus.dtos;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CategoryDto {
    @NotNull(message = "Category ID cannot be empty")
    private Long id;
    @NotNull(message = "Category name cannot be empty")
    private String title;
}