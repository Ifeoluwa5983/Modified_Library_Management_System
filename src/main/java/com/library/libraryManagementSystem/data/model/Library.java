package com.library.libraryManagementSystem.data.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
    @JsonIgnore
    private List<Book> books;

    public void setBook (Book book) {
        if (books == null) {
            books = new ArrayList<>();
        }
        books.add(book);
    }
}
