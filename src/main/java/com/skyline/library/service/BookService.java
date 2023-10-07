package com.skyline.library.service;


import com.skyline.library.entity.Book;

import java.util.List;

public interface BookService {
    Book createBook(Book book);
    List<Book> getAllBooks();
    Book getBookById(Long bookId);
    Book updateBook(Long bookId, Book book);
    void deleteBook(Long bookId);

    // Additional search methods
    List<Book> searchBooksByTitle(String title);
}
