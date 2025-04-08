package com.polarbookshop.catalog_service.dto;

import jakarta.annotation.Nullable;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;

public record BookDto(@NotBlank(message = "Must send isbn") String isbn,

                @Nullable String publisher,

                @NotBlank(message = "Must send title") String title,

                @NotBlank(message = "Must send author") String author,

                @Positive(message = "Must be greater than 0") Double price) {
}
