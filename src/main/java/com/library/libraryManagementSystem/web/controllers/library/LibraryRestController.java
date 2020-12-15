package com.library.libraryManagementSystem.web.controllers.library;

import com.library.libraryManagementSystem.data.exception.LibraryEntityException;
import com.library.libraryManagementSystem.data.model.Library;
import com.library.libraryManagementSystem.service.library.LibraryServiceImpl;
import com.library.libraryManagementSystem.data.exception.NoSuchElementException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
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

    @GetMapping("/allLibraries")
    public ResponseEntity<?> getAllLibraries(){
        List<Library> libraries = libraryService.getAllLibraries();
        log.info("All libraries --> {}", libraries);
        return ResponseEntity.ok().body(libraries);
    }
    @PostMapping("/createLibrary")
    public ResponseEntity<?> createLibrary(@RequestBody Library library)  {
        try {
            libraryService.createLibrary(library);
        } catch (LibraryEntityException exe) {
            ResponseEntity.badRequest().body(exe.getMessage());
        }
        return ResponseEntity.ok().body("created");
    }
    @DeleteMapping("/deleteLibraryById/{id}")
    public ResponseEntity<?> deleteLibraryById(@PathVariable Integer id){
        try{
            libraryService.deleteLibraryById(id);
        }catch (NoSuchElementException exe){
            ResponseEntity.badRequest().body(exe.getMessage());
        }
        return ResponseEntity.ok().body("Deleted");
    }

    @PatchMapping("/updateLibrary")
    public @ResponseBody ResponseEntity<?> updateLibrary(@RequestBody Library library){
        try{
            libraryService.updateLibrary(library);
        } catch (LibraryEntityException exe) {
            ResponseEntity.badRequest().body(exe.getMessage());
        }
        return ResponseEntity.ok().body(library);
    }

    @GetMapping("/findLibraryById/{id}")
    public ResponseEntity<?> findLibraryById(@PathVariable Integer id){

        try{
            mylibrary = libraryService.findLibraryById(id);
        } catch (NoSuchElementException noSuchElementException) {
            ResponseEntity.badRequest().body(noSuchElementException.getMessage());
        }
        return ResponseEntity.ok().body(mylibrary);
    }

}
