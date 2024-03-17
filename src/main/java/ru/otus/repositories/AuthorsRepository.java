package ru.otus.repositories;

import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.otus.entities.Author;

@Repository
@Transactional(readOnly = true)
public interface AuthorsRepository extends ListCrudRepository<Author, Long> {
}