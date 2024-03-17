package ru.otus.repositories;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.otus.entities.Book;

@Repository
@Transactional(readOnly = true)
public interface BooksPagingRepository extends PagingAndSortingRepository<Book, Long> {
}
