package com.library.libraryManagementSystem.data.repository;

import com.library.libraryManagementSystem.data.exception.ExceptionInReaderEntity;
import com.library.libraryManagementSystem.data.model.Reader;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReaderRepository extends JpaRepository<Reader, Integer> {
    default Reader saveReader(Reader reader) throws ExceptionInReaderEntity {
        Reader savedReader = null;
        if(isReaderValid(reader)){
            savedReader = save(reader);
        }
        return savedReader;
    }
    private  boolean isReaderValid(Reader reader) throws ExceptionInReaderEntity {
        if(!readerHasFirstName(reader)){
            throw new ExceptionInReaderEntity("Please input your first name");
        }
        if(!readerHasLastName(reader)){
            throw new ExceptionInReaderEntity("Please input your last name");
        }
        if(!readerHasEmail(reader)){
            throw new ExceptionInReaderEntity("Please input your email");
        }
        return true;
    }
    private boolean readerHasFirstName(Reader reader) throws ExceptionInReaderEntity {
        if(reader.getFirstName() == null){
           return false;
        }
        return true;
    }
    private boolean readerHasLastName(Reader reader) throws ExceptionInReaderEntity {
        if(reader.getLastName() == null){
            return false;
        }
        return true;
    }
    private boolean readerHasEmail(Reader reader) throws ExceptionInReaderEntity {
        if(reader.getEmail() == null){
            return false;
        }
        return true;
    }

}
