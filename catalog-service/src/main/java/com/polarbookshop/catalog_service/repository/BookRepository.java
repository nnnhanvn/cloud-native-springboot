package com.polarbookshop.catalog_service.repository;

import java.util.List;
import java.util.Optional;
import com.polarbookshop.catalog_service.dto.BookDto;

public interface BookRepository {
    List<BookDto> findAll();

    Optional<BookDto> findByIsbn(String isbn);

    boolean existsByIsbn(String isbn);

    BookDto save(BookDto book);

    void deleteByIsbn(String isbn);
}
