package ru.otus.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.otus.dtos.CategoryDto;
import ru.otus.dtos.requests.CreateOrUpdateCategoryDtoRq;
import ru.otus.entities.Category;
import ru.otus.mapper.DtoMapper;
import ru.otus.repositories.CategoriesRepository;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class CategoriesService {

    private final CategoriesRepository categoriesRepository;
    private final DtoMapper mapper;

    public List<Category> findAll() {
        return categoriesRepository.findAll();
    }

    public Optional<Category> findByTitle(String title) {
        return categoriesRepository.findByTitle(title);
    }

    public Optional<Category> findById(Long id) {
        return categoriesRepository.findById(id);
    }

    @Transactional
    public void deleteById(Long id) {
        categoriesRepository.deleteById(id);
    }

    @Transactional
    public CategoryDto createNewCategory(CreateOrUpdateCategoryDtoRq createOrUpdateCategoryDtoRq) {
        Category newCategory = new Category(createOrUpdateCategoryDtoRq.getTitle());
        return mapper.categoryToCategoryDto(categoriesRepository.save(newCategory));
    }

    @Transactional
    public CategoryDto fullUpdateCategory(CreateOrUpdateCategoryDtoRq createOrUpdateCategoryDtoRq) {
        Optional<Category> optionalCategory = categoriesRepository.findById(createOrUpdateCategoryDtoRq.getId());
        if (optionalCategory.isPresent()) {
            Category updatedCategory = optionalCategory.get();
            updatedCategory.setTitle(createOrUpdateCategoryDtoRq.getTitle());
            return mapper.categoryToCategoryDto(categoriesRepository.save(updatedCategory));
        } else {
            throw new CategoryNotFoundException(createOrUpdateCategoryDtoRq.getId());
        }
    }

    private static class CategoryNotFoundException extends RuntimeException {
        public CategoryNotFoundException(Long id) {
            super("Category with id " + id + " not found");
        }
    }
}