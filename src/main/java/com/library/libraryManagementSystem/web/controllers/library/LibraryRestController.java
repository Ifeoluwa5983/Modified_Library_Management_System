package com.library.libraryManagementSystem.web.controllers.library;

import com.library.libraryManagementSystem.data.exception.LibraryException;
import com.library.libraryManagementSystem.data.model.Library;
import com.library.libraryManagementSystem.service.library.LibraryServiceImpl;
import com.library.libraryManagementSystem.data.exception.ItemDoesNotExist;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/library")
@Slf4j
public class LibraryRestController {

    @Autowired
    LibraryServiceImpl libraryService;

    Library mylibrary;

    @GetMapping("/libraries")
    public ResponseEntity<?> getAllLibraries(){
        List<Library> libraries = libraryService.getAllLibraries();
        log.info("All libraries --> {}", libraries);
        return ResponseEntity.ok().body(libraries);
    }
    @PostMapping("/create")
    public ResponseEntity<?> createLibrary(@RequestBody Library library)  {
        try {
            libraryService.createLibrary(library);
        } catch (LibraryException exe) {
            ResponseEntity.badRequest().body(exe.getMessage());
        }
        return new ResponseEntity<>(library, HttpStatus.CREATED);
    }
    @DeleteMapping("one/{id}")
    public ResponseEntity<?> deleteLibraryById(@PathVariable Integer id){
        try{
            libraryService.deleteLibraryById(id);
        }catch (ItemDoesNotExist exe){
            ResponseEntity.badRequest().body(exe.getMessage());
        }
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/update")
    public @ResponseBody ResponseEntity<?> updateLibrary(@RequestBody Library library){
        try{
            libraryService.updateLibrary(library);
        } catch (LibraryException exe) {
            ResponseEntity.badRequest().body(exe.getMessage());
        }
        return ResponseEntity.ok().body(library);
    }

    @GetMapping("one/{id}")
    public ResponseEntity<?> findLibraryById(@PathVariable Integer id){

        try{
            mylibrary = libraryService.findLibraryById(id);
        } catch (ItemDoesNotExist itemDoesNotExist) {
            ResponseEntity.badRequest().body(itemDoesNotExist.getMessage());
        }
        return ResponseEntity.ok().body(mylibrary);
    }

}
