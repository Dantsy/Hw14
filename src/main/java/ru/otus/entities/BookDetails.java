package ru.otus.entities;

import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.PersistenceCreator;
import org.springframework.data.relational.core.mapping.Table;

@Data
@Table("BOOKS_DETAILS")
public class BookDetails {
    @Id
    @NotNull(message = "Book detail ID cannot be empty")
    private Long id;
    @NotNull(message = "Book ID cannot be empty")
    private Long bookId;
    private String description;

    @PersistenceCreator
    public BookDetails(Long id, Long bookId, String description) {
        this.id = id;
        this.bookId = bookId;
        this.description = description;
    }
}