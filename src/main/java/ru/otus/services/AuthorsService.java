package ru.otus.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.otus.entities.Author;
import ru.otus.repositories.AuthorsRepository;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class AuthorsService {
    private final AuthorsRepository authorsRepository;

    @Transactional(readOnly = true)
    public Optional<Author> findById(Long id) {
        return authorsRepository.findById(id);
    }
}