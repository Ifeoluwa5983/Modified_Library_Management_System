package com.library.libraryManagementSystem.service.library;

import com.library.libraryManagementSystem.data.model.Library;
import com.library.libraryManagementSystem.data.repository.LibraryRepository;
import com.library.libraryManagementSystem.web.exception.ItemDoesNotExist;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

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
    public Library updateLibrary(Library library) throws ItemDoesNotExist {
        log.info("Pet Request object --> {}", library);
        Library savedLibrary = libraryRepository.findById(library.getId()).orElse(null);

        if(savedLibrary != null){

            if(library.getName() != null){
                savedLibrary.setName(library.getName());
            }

            log.info("Before saving pet  object --> {}", savedLibrary);
            return libraryRepository.save(savedLibrary);
        }
        else {
            throw new ItemDoesNotExist("Pet with the Id: "+ library.getId() +" Does not exsit");
        }
    }

    @Override
    public Library createLibrary(Library library) throws ItemDoesNotExist {
        if(library == null){
            throw new ItemDoesNotExist("Create a library");
        }
        return libraryRepository.save(library);
    }


}
