package com.library.libraryManagementSystem.data.model;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
public class Library {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    @OneToMany(mappedBy = "library", cascade = CascadeType.ALL)
    private List<Book> books;

    public void addBook (Book book) {
        if (books == null) {
            books = new ArrayList<>();
        }
        books.add(book);
    }
}
