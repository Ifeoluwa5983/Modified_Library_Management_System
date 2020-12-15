package com.library.libraryManagementSystem.service.library;

import com.library.libraryManagementSystem.data.exception.LibraryEntityException;
import com.library.libraryManagementSystem.data.model.Library;
import com.library.libraryManagementSystem.data.exception.NoSuchElementException;

import java.util.List;

public interface LibraryService {

    public List<Library> getAllLibraries();

    public void deleteLibraryById(Integer id) throws NoSuchElementException;

    public Library findLibraryById(Integer id) throws NoSuchElementException;

    public Library updateLibrary(Library library) throws LibraryEntityException;

    public Library createLibrary(Library library) throws LibraryEntityException;
}
