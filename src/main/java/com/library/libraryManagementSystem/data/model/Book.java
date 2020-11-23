package com.library.libraryManagementSystem.data.model;

import lombok.Data;
import lombok.ToString;

import javax.persistence.*;

@Data
@Entity
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private  String title;

    private String author;

    private IsAvailable isAvailable;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @ToString.Exclude
    private Library library;
}
