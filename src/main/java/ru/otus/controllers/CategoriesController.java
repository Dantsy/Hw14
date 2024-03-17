package ru.otus.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.otus.dtos.CategoryDto;
import ru.otus.dtos.requests.CreateOrUpdateCategoryDtoRq;
import ru.otus.dtos.SimplestPageDto;
import ru.otus.entities.Category;
import ru.otus.services.CategoriesService;

import java.util.function.Function;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/categories")
public class CategoriesController {
    private final CategoriesService categoriesService;

    private static final Function<Category, CategoryDto> MAP_TO_DTO_FUNCTION = c -> new CategoryDto(c.getId(), c.getTitle());

    @Autowired
    public CategoriesController(CategoriesService categoriesService) {
        this.categoriesService = categoriesService;
    }

    @GetMapping
    public ResponseEntity<SimplestPageDto<CategoryDto>> findAll() {
        return ResponseEntity.ok(new SimplestPageDto<>(categoriesService.findAll().stream().map(MAP_TO_DTO_FUNCTION).collect(Collectors.toList())));
    }

    @GetMapping("/{id}")
    public ResponseEntity<CategoryDto> findById(@PathVariable Long id) {
        return categoriesService.findById(id).map(MAP_TO_DTO_FUNCTION).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        categoriesService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping
    public ResponseEntity<CategoryDto> createNewCategory(@RequestBody CreateOrUpdateCategoryDtoRq createOrUpdateCategoryDtoRq) {
        CategoryDto categoryDto = categoriesService.createNewCategory(createOrUpdateCategoryDtoRq);
        return ResponseEntity.ok(categoryDto);
    }

    @PutMapping
    public ResponseEntity<CategoryDto> updateCategory(@RequestBody CreateOrUpdateCategoryDtoRq createOrUpdateCategoryDtoRq) {
        CategoryDto categoryDto = categoriesService.fullUpdateCategory(createOrUpdateCategoryDtoRq);
        return ResponseEntity.ok(categoryDto);
    }
}