package com.polarbookshop.catalog_service.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import com.polarbookshop.catalog_service.entity.Book;

public interface BookRepository extends JpaRepository<Book, Long> {
    Optional<Book> findByIsbn(String isbn);

    boolean existsByIsbn(String isbn);

    void deleteByIsbn(String isbn);
}
