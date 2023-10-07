package com.skyline.library.service.impl;
import com.skyline.library.entity.Book;
import com.skyline.library.exception.NotFoundException;
import com.skyline.library.repository.BookRepository;
import com.skyline.library.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookRepository bookRepository;
    @Override
    public Book createBook(Book book) {
        // You can add any necessary validation or business logic here before saving the book.
        return bookRepository.save(book);
    }

    @Override
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    @Override
    public Book getBookById(Long bookId) {
        Optional<Book> bookOptional = bookRepository.findById(bookId);
        return bookOptional.orElseThrow(() -> new NotFoundException("Book Not found for id:"+bookId));
    }

    @Override
    public Book updateBook(Long bookId, Book book) {
        if (!bookRepository.existsById(bookId)) {
            throw new NotFoundException("Book Not found for id:"+bookId);
        }

        book.setId(bookId); // Set the ID explicitly to ensure it's updated.
        return bookRepository.save(book);
    }

    @Override
    public void deleteBook(Long bookId) {
        if (!bookRepository.existsById(bookId)) {
            throw new NotFoundException("Book Not found for id:"+bookId);
        }

        bookRepository.deleteById(bookId);
    }
    @Override
    public List<Book> searchBooksByTitle(String title) {
        return bookRepository.findByBookTitleContainingIgnoreCase(title);
    }
}
