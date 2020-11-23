package com.library.libraryManagementSystem.service.library;

import com.library.libraryManagementSystem.data.model.Library;
import com.library.libraryManagementSystem.web.exception.ItemDoesNotExist;

import java.util.List;

public interface LibraryService {

    public List<Library> getAllLibraries();

    public void deleteLibraryById(Integer id) throws ItemDoesNotExist;

    public Library findLibraryById(Integer id) throws ItemDoesNotExist;

    public Library updateLibrary(Library library) throws ItemDoesNotExist;

    public Library createLibrary(Library library) throws ItemDoesNotExist;
}
