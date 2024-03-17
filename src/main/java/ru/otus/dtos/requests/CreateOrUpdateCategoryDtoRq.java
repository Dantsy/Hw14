package ru.otus.dtos.requests;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class CreateOrUpdateCategoryDtoRq {
    @NotBlank(message = "Category ID cannot be empty")
    private Long id;

    @NotBlank(message = "Category name cannot be empty")
    private String title;
}
