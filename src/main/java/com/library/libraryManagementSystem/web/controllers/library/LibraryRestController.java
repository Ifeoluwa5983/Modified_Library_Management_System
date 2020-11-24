package com.library.libraryManagementSystem.web.controllers.library;

import com.library.libraryManagementSystem.data.model.Library;
import com.library.libraryManagementSystem.service.library.LibraryService;
import com.library.libraryManagementSystem.service.library.LibraryServiceImpl;
import com.library.libraryManagementSystem.web.exception.ItemDoesNotExist;
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
        } catch (NullPointerException | ItemDoesNotExist exe) {
            ResponseEntity.badRequest().body(exe.getMessage());
        }
        return new ResponseEntity<>(library, HttpStatus.CREATED);
    }
    @GetMapping("one/{}")
    public ResponseEntity<?> deleteLibraryById(@PathVariable Integer id){
        try{
            libraryService.deleteLibraryById(id);
        }catch (ItemDoesNotExist exe){
            ResponseEntity.badRequest().body(exe.getMessage());
        }
        return ResponseEntity.noContent().build();
    }

    @PatchMapping("/one/{}")
    public @ResponseBody ResponseEntity<?> updateLibraryById(@RequestBody Library library){
        try{
            libraryService.updateLibrary(library);
        } catch (ItemDoesNotExist itemDoesNotExist) {
            ResponseEntity.badRequest().body(itemDoesNotExist.getMessage());
        }
        return ResponseEntity.ok().body(library);
    }

    @GetMapping("one/{}")
    public ResponseEntity<?> findLibraryById(@PathVariable Integer id){

        try{
            mylibrary = libraryService.findLibraryById(id);
        } catch (ItemDoesNotExist itemDoesNotExist) {
            ResponseEntity.badRequest().body(itemDoesNotExist.getMessage());
        }
        return ResponseEntity.ok().body(mylibrary);
    }
}
