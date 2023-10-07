package com.skyline.library.controller;

import com.skyline.library.entity.Book;
import com.skyline.library.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/books")
public class BookController {

    @Autowired
    private BookService bookService;

    // Search for books by title
    @GetMapping("/search")
    public List<Book> searchBooksByTitle(@RequestParam String title) {
        return bookService.searchBooksByTitle(title);
    }

    @GetMapping("/search")
    public List<Book> searchBooksByAuthorName(@RequestParam("authorName") String authorName) {
        return bookService.findBooksByAuthorName(authorName);
    }
}
