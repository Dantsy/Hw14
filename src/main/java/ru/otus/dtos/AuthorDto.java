package ru.otus.dtos;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AuthorDto {
    @NotNull(message = "Author ID cannot be empty")
    private Long id;
    @NotNull(message = "Author's full name cannot be empty")
    private String fullName;
}