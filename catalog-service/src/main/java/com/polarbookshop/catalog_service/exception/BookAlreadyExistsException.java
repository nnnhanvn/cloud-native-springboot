package com.polarbookshop.catalog_service.exception;

public class BookAlreadyExistsException extends RuntimeException {
    public BookAlreadyExistsException(String isbn) {
        super("The book with ISBN " + isbn + " already exists.");
    }
}
