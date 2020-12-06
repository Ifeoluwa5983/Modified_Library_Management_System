package com.library.libraryManagementSystem.data.repository;

import com.library.libraryManagementSystem.data.model.Reader;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
@Slf4j
class ReaderRepositoryTest {

    @Autowired
    ReaderRepository readerRepository;

    Reader reader;

    @BeforeEach
    void setUp() {
        reader = new Reader();
    }

    @Test
    void testThatWecAnCreateAReader(){
        reader.setFirstName("Ifeoluwa");
        reader.setLastName("Oluwafemi");
        reader.setEmail("o.ifeoluwah@gmail.com");
        reader.setPhoneNumber("07042441564");

        assertDoesNotThrow(()-> {
            readerRepository.saveReader(reader);
        });
    }
    @Test
    void testThatWeCanFindAllReaders(){
       List<Reader> readers = readerRepository.findAll();
       assertNotNull(readers);
       log.info("Readers ->{}",readers);
    }

    @Test
    void testThatWeCanFindReaderById(){
        reader = readerRepository.findById(1).orElse(null);
        assertNotNull(reader);
        log.info("Reader with the id of 1 ->{}",reader);
    }

    @Test
    void testThatWeCanDeleteById(){
       assertThat(readerRepository.existsById(1)).isTrue();
       readerRepository.deleteById(1);
       assertThat(readerRepository.existsById(1)).isFalse();
    }
}