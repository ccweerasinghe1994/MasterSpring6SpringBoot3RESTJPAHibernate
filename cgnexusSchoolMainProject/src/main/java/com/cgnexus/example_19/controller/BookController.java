package com.cgnexus.example_19.controller;

import com.cgnexus.example_19.dto.BookDto;
import com.cgnexus.example_19.model.BookList;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RequestMapping("/book")
@Controller
public class BookController {


    @GetMapping("/list")
    public ResponseEntity<List<BookDto>> list() {
        return ResponseEntity.ok(BookList.books);
    }

}
