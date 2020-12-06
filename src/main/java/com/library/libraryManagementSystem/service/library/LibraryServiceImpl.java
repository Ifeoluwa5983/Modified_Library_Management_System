package com.library.libraryManagementSystem.service.library;

import com.library.libraryManagementSystem.data.exception.LibraryException;
import com.library.libraryManagementSystem.data.model.Library;
import com.library.libraryManagementSystem.data.repository.LibraryRepository;
import com.library.libraryManagementSystem.data.exception.ItemDoesNotExist;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@Slf4j
public class LibraryServiceImpl implements LibraryService {

    @Autowired
    LibraryRepository libraryRepository;


    @Override
    public List<Library> getAllLibraries() {
        return libraryRepository.findAll();
    }

    @Override
    public void deleteLibraryById(Integer id) throws ItemDoesNotExist {
        try {
            libraryRepository.deleteById(id);
        } catch (Exception e) {
            throw new ItemDoesNotExist("The library with the id"+ id + "does not exist");
        }
    }

    @Override
    public Library findLibraryById(Integer id) throws ItemDoesNotExist {
        Library library = libraryRepository.findById(id).orElse(null);
        if(library != null){
            return library;
        }else {
            throw new ItemDoesNotExist("The library with the id\"+ id + \"does not exist");
        }
    }

    @Override
    public Library updateLibrary(Library library) throws LibraryException {
        if(library == null){
            throw new LibraryException("Create a library");
        }
        return libraryRepository.saveLibrary(library);
    }

    @Override
    public Library createLibrary(Library library) throws LibraryException {
        if(library == null){
            throw new LibraryException("Create a library");
        }
        return libraryRepository.saveLibrary(library);
    }


}
