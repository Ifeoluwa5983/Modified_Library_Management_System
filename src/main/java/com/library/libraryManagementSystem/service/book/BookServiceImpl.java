package com.library.libraryManagementSystem.service.book;

import com.library.libraryManagementSystem.data.exception.ExceptionsInBookEntity;
import com.library.libraryManagementSystem.data.model.Book;
import com.library.libraryManagementSystem.data.repository.BookRepository;
import com.library.libraryManagementSystem.data.exception.ItemDoesNotExist;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
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

        Book book = bookRepository.findById(id).orElse(null);

        if(book != null){
            return book;
        }else{
            throw new ItemDoesNotExist("The book with the id does not exist");
        }
    }

    @Override
    public Book updateBook(Book book) throws ExceptionsInBookEntity {
        if(book.getId() == null){
            throw new ExceptionsInBookEntity("Id cannot be null");
        }
        Book newBook = bookRepository.findById(book.getId()).get();
        if(newBook != null){
            throw new ExceptionsInBookEntity("The book does not exists");
        }
        if(book.getIsAvailable() != null){
            newBook.setIsAvailable(book.getIsAvailable());
        }
        if (book.getLibrary() != null){
            newBook.setLibrary(book.getLibrary());
        }
        return bookRepository.saveBook(newBook);
    }

    @Override
    public Book createBook(Book book) throws ExceptionsInBookEntity {
        if(book == null){
            throw new ExceptionsInBookEntity("Please create a book");
        }
        return bookRepository.saveBook(book);
    }


}

