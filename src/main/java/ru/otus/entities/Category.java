package ru.otus.entities;

import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.PersistenceCreator;
import org.springframework.data.relational.core.mapping.Table;

@Data
@Table("CATEGORIES")
public class Category {
    @Id
    @NotNull(message = "Category ID cannot be empty")
    private Long id;
    @NotNull(message = "Category name cannot be empty")
    private String title;

    @PersistenceCreator
    public Category(String title) {
        this.id = id;
        this.title = title;
    }
}