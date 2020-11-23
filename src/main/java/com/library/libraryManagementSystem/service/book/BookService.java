package com.library.libraryManagementSystem.service.book;

import com.library.libraryManagementSystem.data.model.Book;
import com.library.libraryManagementSystem.data.model.Library;
import com.library.libraryManagementSystem.web.exception.ItemDoesNotExist;

import java.util.List;

public interface BookService {
    public List<Book> getAllBooks();

    public void deleteBookById(Integer id) throws ItemDoesNotExist;

    public Book findBookById(Integer id) throws ItemDoesNotExist;

    public Book updateBook(Book book) throws ItemDoesNotExist;

    public Book createBook(Book book) throws ItemDoesNotExist;
}
