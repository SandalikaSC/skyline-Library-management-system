package com.skyline.library.repository;

import com.skyline.library.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
    List<Book> findByBookTitleContainingIgnoreCase(String title);
    @Query("SELECT b FROM Book b WHERE b.author.authorName = :authorName")
    List<Book> findByAuthorName(@Param("authorName") String authorName);
}
