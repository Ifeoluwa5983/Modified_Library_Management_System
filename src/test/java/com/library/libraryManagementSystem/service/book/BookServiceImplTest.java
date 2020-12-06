package com.library.libraryManagementSystem.service.book;

import com.library.libraryManagementSystem.data.exception.BookException;
import com.library.libraryManagementSystem.data.model.Book;
import com.library.libraryManagementSystem.data.repository.BookRepository;
import com.library.libraryManagementSystem.data.exception.ItemDoesNotExist;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.times;

@Slf4j
class BookServiceImplTest {

    @Mock
    BookRepository bookRepository;

    @InjectMocks
    BookService bookService = new BookServiceImpl();

    @Autowired
    BookRepository bookRepositoryImpl;

    Book book;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        book = new Book();
    }

    @Test
    void mockTestForCreateBook() throws BookException {
        when(bookRepository.saveBook(book)).thenReturn(book);
        bookService.createBook(book);
        verify(bookRepository, times(1)).saveBook(book);
    }
    @Test
    void mockTestForFindAllBooks(){
        when(bookRepository.findAll()).thenReturn(List.of(book));
        bookService.getAllBooks();
        verify(bookRepository, times(1)).findAll();
    }

    @Test
    void mockTestForFindBookById() throws ItemDoesNotExist {
        when(bookRepository.findById(3)).thenReturn(Optional.of(book));
        bookService.findBookById(3);
        verify(bookRepository, times(1)).findById(3);
    }

    @Test
    void mockTestForDeleteBookById() throws ItemDoesNotExist {
        doNothing().when(bookRepository).deleteById(3);
        bookService.deleteBookById(3);
        verify(bookRepository, times(1)).deleteById(3);
    }

    @Test
    @Transactional
    @Rollback(value = false)
    void mockTestForUpdatingABook() throws BookException {
        when(bookRepository.saveBook(book)).thenReturn(book);
        book.setTitle("Dead");
        bookService.updateBook(book);
        verify(bookRepository, times(1)).saveBook(book);
    }
}