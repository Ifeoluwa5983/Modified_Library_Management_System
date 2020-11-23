package com.library.libraryManagementSystem.data.repository;

import com.library.libraryManagementSystem.data.model.Book;
import com.library.libraryManagementSystem.data.model.IsAvailable;
import com.library.libraryManagementSystem.data.model.Library;
import lombok.extern.slf4j.Slf4j;
import org.assertj.core.api.AssertionsForClassTypes;
import org.assertj.core.api.AssertionsForInterfaceTypes;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import javax.transaction.Transactional;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Slf4j
class LibraryRepositoryTest {

    @Autowired
    LibraryRepository libraryRepository;

    @Autowired
    BookRepository bookRepository;

    @BeforeEach
    void setUp() {
    }

    @Test
    void createLibraryTest(){
        Library library = new Library();
        library.setName("library");

        libraryRepository.save(library);
        assertThat(library).isNotNull();
        log.info("Saved library --> {}", library);
    }

    @Test
    void deleteLibraryTest(){
        AssertionsForClassTypes.assertThat(libraryRepository.existsById(1)).isTrue();

        libraryRepository.deleteById(1);

        AssertionsForClassTypes.assertThat(libraryRepository.existsById(1)).isFalse();

    }


    @Test
    void whenAllLibrariesAreCalledReturnAll(){
        List<Library> allLibrary = libraryRepository.findAll();

        AssertionsForInterfaceTypes.assertThat(allLibrary).isNotNull();

        log.info("All books --> {}", allLibrary);
    }

}