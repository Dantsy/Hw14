package ru.otus.entities;

import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.PersistenceCreator;
import org.springframework.data.relational.core.mapping.MappedCollection;
import org.springframework.data.relational.core.mapping.Table;

import java.util.List;

@Data
@Table("BOOKS")
public class Book {
    @Id
    @NotNull(message = "Book ID cannot be empty")
    private Long id;
    @NotNull(message = "Book title cannot be empty")
    private String title;
    @NotNull(message = "Author ID cannot be empty")
    private Long authorId;
    private Genre genre;
    @MappedCollection(idColumn = "BOOK_ID")
    private BookDetails bookDetails;

    @MappedCollection(idColumn = "BOOK_ID")
    private List<Review> reviews;

    @PersistenceCreator
    public Book(Long id, String title, Long authorId, BookDetails bookDetails, List<Review> reviews) {
        this.id = id;
        this.title = title;
        this.authorId = authorId;
        this.bookDetails = bookDetails;
        this.reviews = reviews;
    }
}