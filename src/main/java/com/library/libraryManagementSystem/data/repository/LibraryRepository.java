package com.library.libraryManagementSystem.data.repository;

import com.library.libraryManagementSystem.data.exception.BookException;
import com.library.libraryManagementSystem.data.exception.LibraryException;
import com.library.libraryManagementSystem.data.model.Book;
import com.library.libraryManagementSystem.data.model.Library;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LibraryRepository extends JpaRepository<Library, Integer> {
    default Library saveLibrary(Library library) throws LibraryException {
        Library savedLibrary = null;
        if(isLibraryValid(library)){
            savedLibrary = save(library);
        }
        return savedLibrary;
    }

    private boolean isLibraryValid(Library library) throws LibraryException {
        if(!libraryHasBooks(library)){
            throw new LibraryException("Where are the books in the library?");
        }
        if(!libraryHasName(library)){
            throw new LibraryException("Don't be silly! where is the name of the library?");
        }
        return true;
    }
    private boolean libraryHasBooks(Library library){
        if(library.getBooks() == null){
            return false;
        }
        return true;
    }
    private boolean libraryHasName(Library library){
        if(library.getName() == null){
            return false;
        }
        return true;
    }
}
