package ru.otus.dtos;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class PageDto<T> {
    @NotNull(message = "Page number cannot be empty")
    private Integer pageNumber;
    @NotNull(message = "Page size cannot be empty")
    private Integer pageSize;
    @NotNull(message = "The total number of pages cannot be empty")
    private Integer totalPages;
    @NotNull(message = "The total number of elements cannot be empty")
    private Long totalElements;
    private List<T> content;
}