package com.polarbookshop.catalog_service.demo;

import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Profile;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import com.polarbookshop.catalog_service.dto.BookDto;
import com.polarbookshop.catalog_service.repository.BookRepository;
import lombok.AllArgsConstructor;

@Component
@Profile("testdata")
@AllArgsConstructor
public class BookDataLoader {
    private final BookRepository bookRepository;

    @EventListener(ApplicationReadyEvent.class)
    public void loadBookTestData() {
        BookDto book1 = new BookDto("1", "title1", "author1", 1D);
        bookRepository.save(book1);

        BookDto book2 = new BookDto("2", "title2", "author2", 2D);
        bookRepository.save(book2);
    }
}
