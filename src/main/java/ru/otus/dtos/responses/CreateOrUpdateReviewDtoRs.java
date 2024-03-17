package ru.otus.dtos.responses;

import lombok.Data;

import java.time.ZonedDateTime;

@Data
public class CreateOrUpdateReviewDtoRs {

    private Long id;

    private Long bookId;

    private ZonedDateTime reviewDate;

    private String userName;

    private Integer score;

    private String text;
}