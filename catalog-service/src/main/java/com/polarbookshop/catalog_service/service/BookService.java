package com.polarbookshop.catalog_service.service;

import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.polarbookshop.catalog_service.dto.BookDto;
import com.polarbookshop.catalog_service.exception.BookAlreadyExistsException;
import com.polarbookshop.catalog_service.exception.BookNotFoundException;
import com.polarbookshop.catalog_service.mapping.BookMapping;
import com.polarbookshop.catalog_service.repository.BookRepository;
import lombok.AllArgsConstructor;

@Service
@Transactional(readOnly = true)
@AllArgsConstructor
public class BookService {
    private BookRepository bookRepository;

    public List<BookDto> viewBookList() {
        return bookRepository.findAll().stream().map(book -> BookMapping.convertEntityToDto(book))
                .toList();
    }

    public BookDto viewBookDetails(String isbn) {
        return bookRepository.findByIsbn(isbn).map(book -> BookMapping.convertEntityToDto(book))
                .orElseThrow(() -> new BookNotFoundException(isbn));
    }

    @Transactional
    public BookDto addBookToCatalog(BookDto bookDto) {
        if (bookRepository.existsByIsbn(bookDto.isbn())) {
            throw new BookAlreadyExistsException(bookDto.isbn());
        }

        bookRepository.save(BookMapping.convertDtoToEntity(bookDto));
        return bookDto;
    }

    @Transactional
    public void removeBookFromCatalog(String isbn) {
        bookRepository.deleteByIsbn(isbn);
    }

    @Transactional
    public BookDto editBookDetails(String isbn, BookDto bookDto) {
        return bookRepository.findByIsbn(isbn).map(existingBook -> {
            existingBook.setTitle(bookDto.title());
            existingBook.setAuthor(bookDto.author());
            existingBook.setPrice(bookDto.price());
            bookRepository.save(existingBook);
            return bookDto;
        }).orElseGet(() -> {
            addBookToCatalog(bookDto);
            return bookDto;
        });
    }
}
