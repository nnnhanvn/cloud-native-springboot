package com.polarbookshop.catalog_service.demo;

import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Profile;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import com.polarbookshop.catalog_service.entity.Book;
import com.polarbookshop.catalog_service.repository.BookRepository;
import lombok.AllArgsConstructor;

@Component
@Profile("testdata")
@AllArgsConstructor
public class BookDataLoader {
    private final BookRepository bookRepository;

    @EventListener(ApplicationReadyEvent.class)
    public void loadBookTestData() {
        Book book1 = new Book();
        book1.setIsbn("1");
        book1.setTitle("title1");
        book1.setAuthor("author1");
        book1.setPrice(1D);
        bookRepository.save(book1);

        Book book2 = new Book();
        book2.setIsbn("2");
        book2.setTitle("title2");
        book2.setAuthor("author2");
        book2.setPrice(2D);
        bookRepository.save(book2);
    }
}
