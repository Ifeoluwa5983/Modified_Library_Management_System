package com.library.libraryManagementSystem.web.controllers.book;

import com.library.libraryManagementSystem.data.exception.BookException;
import com.library.libraryManagementSystem.data.exception.ItemDoesNotExist;
import com.library.libraryManagementSystem.data.model.Book;
import com.library.libraryManagementSystem.service.book.BookServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/book")
@Slf4j
public class BookRestController {

    @Autowired
    BookServiceImpl bookService;

    Book myBook;

    @GetMapping("/libraries")
    public ResponseEntity<?> getAllBooks(){
        List<Book> books = bookService.getAllBooks();
        log.info("All libraries --> {}", books);
        return ResponseEntity.ok().body(books);
    }
    @PostMapping("/create")
    public ResponseEntity<?> createBook(@RequestBody Book book)  {
        try {
            bookService.createBook(book);
        } catch (BookException exe) {
            ResponseEntity.badRequest().body(exe.getMessage());
        }
        return new ResponseEntity<>(book, HttpStatus.CREATED);
    }
    @DeleteMapping("one/{id}")
    public ResponseEntity<?> deleteBookById(@PathVariable Integer id){
        try{
            bookService.deleteBookById(id);
        }catch (ItemDoesNotExist exe){
            ResponseEntity.badRequest().body(exe.getMessage());
        }
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/update")
    public @ResponseBody ResponseEntity<?> updateBook(@RequestBody Book book){
        try{
            bookService.updateBook(book);
        } catch (BookException exe) {
            ResponseEntity.badRequest().body(exe.getMessage());
        }
        return ResponseEntity.ok().body(book);
    }

    @GetMapping("one/{id}")
    public ResponseEntity<?> findBookById(@PathVariable Integer id){

        try{
            myBook = bookService.findBookById(id);
        } catch (ItemDoesNotExist itemDoesNotExist) {
            ResponseEntity.badRequest().body(itemDoesNotExist.getMessage());
        }
        return ResponseEntity.ok().body(myBook);
    }
}
