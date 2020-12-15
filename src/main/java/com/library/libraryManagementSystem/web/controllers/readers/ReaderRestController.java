package com.library.libraryManagementSystem.web.controllers.readers;

import com.library.libraryManagementSystem.data.exception.NoSuchElementException;
import com.library.libraryManagementSystem.data.exception.ReaderEntityException;
import com.library.libraryManagementSystem.data.model.Reader;
import com.library.libraryManagementSystem.service.reader.ReaderServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/reader")
@Slf4j
public class ReaderRestController {

    @Autowired
    ReaderServiceImpl readerService;

    Reader reader;

    @GetMapping("/allReaders")
    public ResponseEntity<?> getAllReaders(){
        List<Reader> readers = readerService.getAllReaders();
        log.info("All libraries --> {}", readers);
        return ResponseEntity.ok().body(readers);
    }
    @PostMapping("/createReader")
    public ResponseEntity<?> createReader(@RequestBody Reader reader)  {
        try {
            readerService.createReader(reader);
        } catch (ReaderEntityException exe) {
            ResponseEntity.badRequest().body(exe.getMessage());
        }
        return ResponseEntity.ok().body("created");
    }
    @DeleteMapping("/deleteReaderById/{id}")
    public ResponseEntity<?> deleteReaderById(@PathVariable Integer id){
        try{
            readerService.deleteReaderById(id);
        }catch (NoSuchElementException exe){
            ResponseEntity.badRequest().body(exe.getMessage());
        }
        return ResponseEntity.ok().body("Deleted");
    }

    @PatchMapping("/updateReader")
    public @ResponseBody ResponseEntity<?> updateReader(@RequestBody Reader reader){
        try{
            readerService.updateReader(reader);
        } catch (ReaderEntityException exe) {
            ResponseEntity.badRequest().body(exe.getMessage());
        }
        return ResponseEntity.ok().body(reader);
    }

    @GetMapping("/findReaderById/{id}")
    public ResponseEntity<?> findReaderById(@PathVariable Integer id){

        try{
            reader = readerService.findReaderById(id);
        } catch (NoSuchElementException noSuchElementException) {
            ResponseEntity.badRequest().body(noSuchElementException.getMessage());
        }
        return ResponseEntity.ok().body(reader);
    }
}
