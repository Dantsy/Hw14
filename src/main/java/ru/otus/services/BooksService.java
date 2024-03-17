package ru.otus.services;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.otus.dtos.BookDto;
import ru.otus.dtos.DetailedBookDto;
import ru.otus.dtos.PageDto;
import ru.otus.entities.Book;
import ru.otus.mapper.DtoMapper;
import ru.otus.repositories.BooksPagingRepository;
import ru.otus.repositories.BooksRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class BooksService {
    private final BooksRepository booksRepository;

    private final BooksPagingRepository booksPagedRepository;

    private final DtoMapper mapper;

    @Transactional(readOnly = true)
    public PageDto<DetailedBookDto> findAllDetailedBooksPaged(Pageable pageable) {

        List<DetailedBookDto> contentList = booksRepository.findAllDetailedBooksWithPagination(
                LocalDate.now().minusMonths(1),
                pageable.getSort().get().findFirst().map(Sort.Order::getProperty).orElse(""),
                pageable.getSort().get().findFirst().map(order -> order.getDirection().isAscending()).orElse(false),
                pageable);

        long totalElements = booksRepository.count();
        int totalPages = (int) Math.ceil((double) totalElements / pageable.getPageSize());

        return new PageDto<>(pageable.getPageNumber(), pageable.getPageSize(), totalPages,
                totalElements, contentList);

    }

    @Transactional(readOnly = true)
    public PageDto<BookDto> findAllBooksPaged(Pageable pageable) {
        Page<Book> pagedList = booksPagedRepository.findAll(pageable);
        List<BookDto> bookDtos = pagedList.getContent().stream()
                .map(mapper::bookToBookDto)
                .collect(Collectors.toList());
        return new PageDto<>(pageable.getPageNumber(), pageable.getPageSize(), pagedList.getTotalPages(),
                pagedList.getTotalElements(), bookDtos);
    }

    @Transactional
    public void updateTitleById(Long id, String newTitle) {
        booksRepository.changeTitleById(id, newTitle);
    }
}