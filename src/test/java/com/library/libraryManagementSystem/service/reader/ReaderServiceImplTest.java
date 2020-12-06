package com.library.libraryManagementSystem.service.reader;

import com.library.libraryManagementSystem.data.exception.BookException;
import com.library.libraryManagementSystem.data.exception.ItemDoesNotExist;
import com.library.libraryManagementSystem.data.exception.ReaderException;
import com.library.libraryManagementSystem.data.model.Book;
import com.library.libraryManagementSystem.data.model.Reader;
import com.library.libraryManagementSystem.data.repository.BookRepository;
import com.library.libraryManagementSystem.data.repository.ReaderRepository;
import com.library.libraryManagementSystem.service.book.BookService;
import com.library.libraryManagementSystem.service.book.BookServiceImpl;
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

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class ReaderServiceImplTest {
    @Mock
    ReaderRepository readerRepository;

    @InjectMocks
    ReaderService readerService = new ReaderServiceImpl();

   Reader reader;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        reader = new Reader();
    }

    @Test
    void mockTestForCreateBook() throws ReaderException {
        when(readerRepository.saveReader(reader)).thenReturn(reader);
        readerService.createReader(reader);
        verify(readerRepository, times(1)).saveReader(reader);
    }
    @Test
    void mockTestForFindAllBooks(){
        when(readerRepository.findAll()).thenReturn(List.of(reader));
        readerService.getAllReaders();
        verify(readerRepository, times(1)).findAll();
    }

    @Test
    void mockTestForFindBookById() throws ItemDoesNotExist {
        when(readerRepository.findById(2)).thenReturn(Optional.of(reader));
        readerService.findReaderById(2);
        verify(readerRepository, times(1)).findById(2);
    }

    @Test
    void mockTestForDeleteBookById() throws ItemDoesNotExist {
        doNothing().when(readerRepository).deleteById(1);
        readerService.deleteReaderById(1);
        verify(readerRepository, times(1)).deleteById(1);
    }

    @Test
    @Transactional
    @Rollback(value = false)
    void mockTestForUpdatingABook() throws BookException, ReaderException {
        when(readerRepository.saveReader(reader)).thenReturn(reader);
        reader.setLastName("Chima");
        readerService.updateReader(reader);
        verify(readerRepository, times(1)).saveReader(reader);
    }

}