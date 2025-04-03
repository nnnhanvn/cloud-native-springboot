package com.polarbookshop.catalog_service.service;

import java.util.List;
import org.springframework.stereotype.Service;
import com.polarbookshop.catalog_service.dto.BookDto;
import com.polarbookshop.catalog_service.exception.BookAlreadyExistsException;
import com.polarbookshop.catalog_service.exception.BookNotFoundException;
import com.polarbookshop.catalog_service.repository.BookRepository;

@Service
public class BookService {
    private BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public List<BookDto> viewBookList() {
        return bookRepository.findAll();
    }

    public BookDto viewBookDetails(String isbn) {
        return bookRepository.findByIsbn(isbn).orElseThrow(() -> new BookNotFoundException(isbn));
    }

    public BookDto addBookToCatalog(BookDto bookDto) {
        if (bookRepository.existsByIsbn(bookDto.isbn())) {
            throw new BookAlreadyExistsException(bookDto.isbn());
        }
        return bookRepository.save(bookDto);
    }

    public void removeBookFromCatalog(String isbn) {
        bookRepository.deleteByIsbn(isbn);
    }

    public BookDto editBookDetails(String isbn, BookDto bookDto) {
        return bookRepository.findByIsbn(isbn).map(existingBook -> {
            var bookToUpdate = new BookDto(existingBook.isbn(), bookDto.title(), bookDto.author(),
                    bookDto.price());
            return bookRepository.save(bookToUpdate);
        }).orElseGet(() -> addBookToCatalog(bookDto));
    }
}
