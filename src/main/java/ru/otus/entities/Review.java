package ru.otus.entities;

import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.PersistenceCreator;
import org.springframework.data.relational.core.mapping.Table;

import java.util.Date;

@Data
@Table("REVIEWS")
public class Review {
    @Id
    @NotNull(message = "Review ID cannot be empty")
    private Long id;
    @NotNull(message = "Book ID cannot be empty")
    private Long bookId;
    private Date reviewDate;
    @NotNull(message = "Username cannot be empty")
    private String userName;
    private Integer score;
    private String text;

    @PersistenceCreator
    public Review(Long id, Long bookId, Date reviewDate, String userName, Integer score, String text) {
        this.id = id;
        this.bookId = bookId;
        this.reviewDate = reviewDate;
        this.userName = userName;
        this.score = score;
        this.text = text;
    }
}