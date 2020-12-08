package com.library.libraryManagementSystem.data.repository;

import com.library.libraryManagementSystem.data.exception.ExceptionsInBookEntity;
import com.library.libraryManagementSystem.data.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Integer> {

    default Book saveBook(Book book) throws ExceptionsInBookEntity {
        Book savedBook = null;
        if(isBookValid(book)){
            savedBook = save(book);
        }
        return savedBook;
    }

    private boolean isBookValid(Book book) throws ExceptionsInBookEntity {
        if(!bookHasLibrary(book)){
            throw new ExceptionsInBookEntity("Where is the registered library for this book?");
        }
        if(!bookHasAuthor(book)){
            throw new ExceptionsInBookEntity("Who wrote this book?");
        }
        if(!bookHasTitle(book)){
            throw new ExceptionsInBookEntity("Don't be silly! where is the title?");
        }
        return true;
    }
    private boolean bookHasLibrary(Book book){
        if(book.getLibrary() == null){
            return false;
        }
        return true;
    }
    private boolean bookHasTitle(Book book){
        if(book.getTitle() == null){
            return false;
        }
        return true;
    }
    private boolean bookHasAuthor(Book book){
        if(book.getAuthor() == null){
            return false;
        }
        return true;
    }

}
