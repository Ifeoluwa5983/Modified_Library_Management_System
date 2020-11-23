package com.library.libraryManagementSystem.service.library;

import com.library.libraryManagementSystem.data.model.Library;
import com.library.libraryManagementSystem.data.repository.LibraryRepository;
import com.library.libraryManagementSystem.web.exception.ItemDoesNotExist;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@Slf4j
class LibraryServiceImplTest {

    @Mock
    LibraryRepository libraryRepository;

    @Autowired
    LibraryRepository libraryRepositoryImpl;

    @InjectMocks
    LibraryService libraryService = new LibraryServiceImpl();

    Library library;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);

        library = new Library();
    }

    @Test
    void mockTestForDeleteLibrary() throws ItemDoesNotExist {
        doNothing().when(libraryRepository).deleteById(3);
        libraryService.deleteLibraryById(3);
        verify(libraryRepository, times(1)).deleteById(3);
    }

    @Test
    void mockTestForFindLibraryById() throws ItemDoesNotExist {
        when(libraryRepository.findById(4)).thenReturn(Optional.of(library));
        libraryService.findLibraryById(4);
        verify(libraryRepository, times(1)).findById(4);
    }

    @Test
    void mockTestForCreateLibrary() throws ItemDoesNotExist {
        when(libraryRepository.save(library)).thenReturn(library);
        libraryService.createLibrary(library);
        verify(libraryRepository, times(1)).save(library);
    }
    @Test
    void mockTestForFindAllLibraries(){
        when(libraryRepository.findAll()).thenReturn(List.of(library));
        libraryService.getAllLibraries();
        verify(libraryRepository, times(1)).findAll();
    }

    @Test
    void mockTestForUpdatingALibrary(){
        Library testLibrary = libraryRepositoryImpl.findById(4).orElse(null);
        assertThat(testLibrary).isNotNull();
        log.info("Library before saving --> {}", testLibrary);

        testLibrary.setName("Ife's library");
        libraryRepositoryImpl.save(testLibrary);
        log.info("Library after saving --> {}", testLibrary);
    }
}