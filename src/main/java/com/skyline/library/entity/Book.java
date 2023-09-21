package com.skyline.library.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "bookId")
    private Long id;

    @Column(name = "book_title")
    private String bookTitle;

    @Column(name = "isbn")
    private String ISBN;

    @Column(name = "day_received")
    private LocalDateTime dayReceived;

    @ManyToOne
    @JoinColumn(name = "author")
    private Author author;

    @ManyToMany
    @JoinTable(
            name = "book_category",
            joinColumns = @JoinColumn(name = "bookId"),
            inverseJoinColumns = @JoinColumn(name = "categoryId")
    )
    private List<Category> categoryList;
}
