package com.cgnexus.example_19.model;

import com.cgnexus.example_19.dto.BookDto;

import java.util.ArrayList;
import java.util.List;

public class BookList {
    public static final List<BookDto> books = new ArrayList<>();

    static {
        books.add(new BookDto(1, "The Great Gatsby"));
        books.add(new BookDto(2, "To Kill a Mockingbird"));
        books.add(new BookDto(3, "1984"));
        books.add(new BookDto(4, "Pride and Prejudice"));
        books.add(new BookDto(5, "The Catcher in the Rye"));
    }
}
