package com.library.libraryManagementSystem.service.book;

import com.library.libraryManagementSystem.data.exception.BookEntityException;
import com.library.libraryManagementSystem.data.model.Book;
import com.library.libraryManagementSystem.data.exception.NoSuchElementException;

import java.util.List;

public interface BookService {
    public List<Book> getAllBooks();

    public void deleteBookById(Integer id) throws NoSuchElementException;

    public Book findBookById(Integer id) throws NoSuchElementException;

    public Book updateBook(Book book) throws BookEntityException;

    public Book createBook(Book book) throws BookEntityException;
}
