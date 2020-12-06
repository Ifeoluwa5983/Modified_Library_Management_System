package com.library.libraryManagementSystem.data.repository;

import com.library.libraryManagementSystem.data.exception.BookException;
import com.library.libraryManagementSystem.data.model.Book;
import com.library.libraryManagementSystem.data.model.IsAvailable;
import com.library.libraryManagementSystem.data.model.Library;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.jdbc.Sql;

import javax.transaction.Transactional;

import java.util.List;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Slf4j
class BookRepositoryTest {

    @Autowired
    BookRepository bookRepository;

    @Autowired
    LibraryRepository libraryRepository;

    @BeforeEach
    void setUp() {
    }

    @Test
    void createBookTest(){
        Book book = new Book();
        book.setAuthor("Techie");
        book.setIsAvailable(IsAvailable.FALSE);
        book.setTitle("Achievements");

        assertThrows(BookException.class, ()->{
            bookRepository.saveBook(book);
        });

        log.info("Book after saving --> {}", book);
    }

    @Test
    void deleteBookTest(){
        assertThat(bookRepository.existsById(1)).isTrue();

        bookRepository.deleteById(1);

        assertThat(bookRepository.existsById(1)).isFalse();

    }

    @Test
    @Transactional
    @Rollback(value = false)
    void returnForeignKeyWhenBookIsMappedToLibrary(){
        Book book = new Book();
        book.setAuthor("Ifeoluwa");
        book.setIsAvailable(IsAvailable.FALSE);
        book.setTitle("The map");

        bookRepository.save(book);

        Library library = new Library();
        library.setName("My library");

        libraryRepository.save(library);

        book.setLibrary(library);

        assertThat(book).isNotNull();
        assertThat(library).isNotNull();
        assertThat(book.getLibrary()).isEqualTo(library);

        log.info("Book after saved --> {}", book);
    }

    @Test
    void whenAllBooksAreCalledReturnAll(){
        List<Book> allBooks = bookRepository.findAll();

        assertThat(allBooks).isNotNull();

        log.info("All books --> {}", allBooks);
    }

    @Test
    void whenIMapABookToALibrary_thenIShouldGetTheBookFromTheLibrary(){
        Book book = new Book();
        book.setAuthor("Ifeoluwa Oluwa");
        book.setIsAvailable(IsAvailable.TRUE);
        book.setTitle("Please");

        Book book2 = new Book();
        book2.setAuthor("Dorcas");
        book2.setIsAvailable(IsAvailable.TRUE);
        book2.setTitle("Family man");

        Library library = new Library();
        library.setName("My library");

        book.setLibrary(library);
        book2.setLibrary(library);

        library.addBook(book);
        library.addBook(book2);

        bookRepository.save(book);
        bookRepository.save(book);
        libraryRepository.save(library);

        assertThat(book).isNotNull();
        assertThat(book2).isNotNull();
        assertThat(library).isNotNull();

        log.info("library after saved --> {}", library);
    }

}