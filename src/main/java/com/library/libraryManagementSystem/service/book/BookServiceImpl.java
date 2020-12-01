package com.library.libraryManagementSystem.service.book;

import com.library.libraryManagementSystem.data.exception.BookException;
import com.library.libraryManagementSystem.data.model.Book;
import com.library.libraryManagementSystem.data.repository.BookRepository;
import com.library.libraryManagementSystem.web.exception.ItemDoesNotExist;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class BookServiceImpl implements BookService {

    @Autowired
    BookRepository bookRepository;

    @Override
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    @Override
    public void deleteBookById(Integer id) throws ItemDoesNotExist {
        try{
            bookRepository.deleteById(id);
        }catch (Exception e){
            throw new ItemDoesNotExist("The book with the id does not exist");
        }
    }

    @Override
    public Book findBookById(Integer id) throws ItemDoesNotExist {
        if(bookRepository.existsById(id)){
            return bookRepository.findById(id).get();
        }else{
            throw new ItemDoesNotExist("The book with the id does not exist");
        }
    }

    @Override
    public Book updateBook(Book book) throws BookException {
        if(book == null){
            throw new BookException("Please create a book");
        }
        return bookRepository.saveBook(book);
    }

    @Override
    public Book createBook(Book book) throws BookException {
        if(book == null){
            throw new BookException("Please create a book");
        }
        return bookRepository.saveBook(book);
    }


}

