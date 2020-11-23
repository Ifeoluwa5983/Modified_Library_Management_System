package com.library.libraryManagementSystem.data.repository;

import com.library.libraryManagementSystem.data.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Integer> {

}
