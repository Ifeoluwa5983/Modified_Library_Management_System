package com.library.libraryManagementSystem.web.controllers.readers;

import com.library.libraryManagementSystem.data.exception.ItemDoesNotExist;
import com.library.libraryManagementSystem.data.exception.ExceptionInReaderEntity;
import com.library.libraryManagementSystem.data.model.Reader;
import com.library.libraryManagementSystem.service.reader.ReaderServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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

    @GetMapping("/libraries")
    public ResponseEntity<?> getAllReaders(){
        List<Reader> readers = readerService.getAllReaders();
        log.info("All libraries --> {}", readers);
        return ResponseEntity.ok().body(readers);
    }
    @PostMapping("/create")
    public ResponseEntity<?> createReader(@RequestBody Reader reader)  {
        try {
            readerService.createReader(reader);
        } catch (ExceptionInReaderEntity exe) {
            ResponseEntity.badRequest().body(exe.getMessage());
        }
        return new ResponseEntity<>(reader, HttpStatus.CREATED);
    }
    @DeleteMapping("one/{id}")
    public ResponseEntity<?> deleteReaderById(@PathVariable Integer id){
        try{
            readerService.deleteReaderById(id);
        }catch (ItemDoesNotExist exe){
            ResponseEntity.badRequest().body(exe.getMessage());
        }
        return ResponseEntity.ok().body("Deleted");
    }

    @PatchMapping("/update")
    public @ResponseBody ResponseEntity<?> updateReader(@RequestBody Reader reader){
        try{
            readerService.updateReader(reader);
        } catch (ExceptionInReaderEntity exe) {
            ResponseEntity.badRequest().body(exe.getMessage());
        }
        return ResponseEntity.ok().body(reader);
    }

    @GetMapping("one/{id}")
    public ResponseEntity<?> findReaderById(@PathVariable Integer id){

        try{
            reader = readerService.findReaderById(id);
        } catch (ItemDoesNotExist itemDoesNotExist) {
            ResponseEntity.badRequest().body(itemDoesNotExist.getMessage());
        }
        return ResponseEntity.ok().body(reader);
    }
}
