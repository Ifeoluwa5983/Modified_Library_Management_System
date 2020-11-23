package com.library.libraryManagementSystem.service.book;

import com.library.libraryManagementSystem.data.model.Book;
import com.library.libraryManagementSystem.data.model.Library;
import com.library.libraryManagementSystem.data.repository.BookRepository;
import com.library.libraryManagementSystem.service.library.LibraryService;
import com.library.libraryManagementSystem.service.library.LibraryServiceImpl;
import com.library.libraryManagementSystem.web.exception.ItemDoesNotExist;
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
import static org.junit.jupiter.api.Assertions.*;
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
    void mockTestForDeleteLibrary() throws ItemDoesNotExist {
        doNothing().when(bookRepository).deleteById(3);
        bookService.deleteBookById(3);
        verify(bookRepository, times(1)).deleteById(3);
    }

    @Test
    void mockTestForFindLibraryById() throws ItemDoesNotExist {
        when(bookRepository.findById(4)).thenReturn(Optional.of(book));
        bookService.findBookById(4);
        verify(bookRepository, times(1)).findById(4);
    }

    @Test
    void mockTestForCreateLibrary() throws ItemDoesNotExist {
        when(bookRepository.save(book)).thenReturn(book);
        bookService.createBook(book);
        verify(bookRepository, times(1)).save(book);
    }
    @Test
    void mockTestForFindAllLibraries(){
        when(bookRepository.findAll()).thenReturn(List.of(book));
        bookService.getAllBooks();
        verify(bookRepository, times(1)).findAll();
    }

    @Test
    @Transactional
    @Rollback(value = false)
    void mockTestForUpdatingALibrary(){
        Book testBook = bookRepositoryImpl.findById(4).orElse(null);
        assertThat(testBook).isNotNull();
        log.info("Library before saving --> {}", testBook);

        testBook.setTitle("Accidental mistress");
        bookRepositoryImpl.save(testBook);
        log.info("Library after saving --> {}", testBook);
    }
}