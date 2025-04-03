package com.polarbookshop.catalog_service.repository;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import org.springframework.stereotype.Repository;
import com.polarbookshop.catalog_service.dto.BookDto;

@Repository
public class InMemoryBookRepository implements BookRepository {
    private static final Map<String, BookDto> books = new ConcurrentHashMap<>();

    @Override
    public List<BookDto> findAll() {
        return books.values().stream().toList();
    }

    @Override
    public Optional<BookDto> findByIsbn(String isbn) {
        return existsByIsbn(isbn) ? Optional.of(books.get(isbn)) : Optional.empty();
    }

    @Override
    public boolean existsByIsbn(String isbn) {
        return books.get(isbn) != null;
    }

    @Override
    public BookDto save(BookDto book) {
        books.put(book.isbn(), book);
        return book;
    }

    @Override
    public void deleteByIsbn(String isbn) {
        books.remove(isbn);
    }
}
