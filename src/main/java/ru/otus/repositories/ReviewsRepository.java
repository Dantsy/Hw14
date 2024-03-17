package ru.otus.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.otus.entities.Review;

import java.util.List;

@Repository
@Transactional(readOnly = true)
public interface ReviewsRepository extends CrudRepository<Review, Long> {

    List<Review> findAllByBookId(Long bookId);
}
