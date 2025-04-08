package com.polarbookshop.catalog_service.mapping;

import com.polarbookshop.catalog_service.dto.BookDto;
import com.polarbookshop.catalog_service.entity.Book;

public class BookMapping {
    public static Book convertDtoToEntity(BookDto bookDto) {
        Book book = new Book();
        book.setIsbn(bookDto.isbn());
        book.setPublisher(bookDto.publisher());
        book.setTitle(bookDto.title());
        book.setAuthor(bookDto.author());
        book.setPrice(bookDto.price());
        return book;
    }

    public static BookDto convertEntityToDto(Book book) {
        return new BookDto(book.getIsbn(), book.getPublisher(), book.getTitle(), book.getAuthor(),
                book.getPrice());
    }
}
