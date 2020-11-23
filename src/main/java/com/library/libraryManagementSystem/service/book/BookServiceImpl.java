package com.library.libraryManagementSystem.service.book;

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
    public Book updateBook(Book book) throws ItemDoesNotExist {
        Book book1 = bookRepository.findById(book.getId()).orElse(null);

        if(book1 != null){
            if(book1.getAuthor() != null){
                book1.setAuthor(book.getAuthor());
            }
            if(book1.getTitle() != null){
                book1.setTitle(book.getTitle());
            }
            if(book1.getIsAvailable() != null){
                book1.setIsAvailable(book.getIsAvailable());
            }
            if(book1.getLibrary() != null){
                book1.setLibrary(book.getLibrary());
            }
            return bookRepository.save(book1);
        }else {
            throw new ItemDoesNotExist("The book with the id does not exist");
        }
    }

    @Override
    public Book createBook(Book book) throws ItemDoesNotExist {
        if(book == null){
            throw new ItemDoesNotExist("Please create a book");
        }
        return bookRepository.save(book);
    }


}

