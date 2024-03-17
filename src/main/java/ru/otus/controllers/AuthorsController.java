package ru.otus.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.otus.dtos.AuthorDto;
import ru.otus.entities.Author;
import ru.otus.services.AuthorsService;

import java.util.function.Function;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/authors")
public class AuthorsController {
    private final AuthorsService authorsService;

    private static final Function<Author, AuthorDto> MAP_TO_DTO_FUNCTION = a -> new AuthorDto(a.getId(), a.getFullName());

    @GetMapping("/{id}")
    public ResponseEntity<AuthorDto> findById(@PathVariable Long id) {
        return authorsService.findById(id).map(MAP_TO_DTO_FUNCTION).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }
}