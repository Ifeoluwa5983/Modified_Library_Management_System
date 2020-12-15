package com.library.libraryManagementSystem.web.controllers.book;

import com.library.libraryManagementSystem.data.exception.BookEntityException;
import com.library.libraryManagementSystem.data.exception.NoSuchElementException;
import com.library.libraryManagementSystem.data.model.Book;
import com.library.libraryManagementSystem.service.book.BookServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
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

    @GetMapping("/allBooks")
    public ResponseEntity<?> getAllBooks(){
        List<Book> books = bookService.getAllBooks();
        log.info("All libraries --> {}", books);
        return ResponseEntity.ok().body(books);
    }
    @PostMapping("/createBook")
    public ResponseEntity<?> createBook(@RequestBody Book book)  {
        try {
            bookService.createBook(book);
        } catch (BookEntityException exe) {
            ResponseEntity.badRequest().body(exe.getMessage());
        }
        return ResponseEntity.ok().body("Created");
    }
    @DeleteMapping("/deleteBookById/{id}")
    public ResponseEntity<?> deleteBookById(@PathVariable Integer id){
        try{
            bookService.deleteBookById(id);
        }catch (NoSuchElementException exe){
            ResponseEntity.badRequest().body(exe.getMessage());
        }
        return ResponseEntity.ok().body("Deleted");
    }


    @PatchMapping("/updateBook")
    public @ResponseBody ResponseEntity<?> updateBook(@RequestBody Book book){
        try{
            bookService.updateBook(book);
        } catch (BookEntityException exe) {
            ResponseEntity.badRequest().body(exe.getMessage());
        }
        return ResponseEntity.ok().body(book);
    }

    @GetMapping("/findBookById/{id}")
    public ResponseEntity<?> findBookById(@PathVariable Integer id){

        try{
            myBook = bookService.findBookById(id);
        } catch (NoSuchElementException noSuchElementException) {
            ResponseEntity.badRequest().body(noSuchElementException.getMessage());
        }
        return ResponseEntity.ok().body(myBook);
    }
}
