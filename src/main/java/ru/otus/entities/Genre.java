package ru.otus.entities;

import lombok.Getter;

@Getter
public enum Genre {
    SCIFI("Science Fiction"),
    MYSTERY("Mystery"),
    DYSTOPIAN("Dystopian"),
    POLITICAL("Political"),
    HORROR("Horror"),
    CLASSIC_FICTION("Classic Fiction"),
    ROMANCE("Romance"),
    ADVENTURE("Adventure"),
    FANTASY("Fantasy"),
    SCIENCE("Science");

    private String name;

    Genre(String name) {
        this.name = name;
    }
}
