package com.library.libraryManagementSystem.service.reader;

import com.library.libraryManagementSystem.data.exception.BookException;
import com.library.libraryManagementSystem.data.exception.ReaderException;
import com.library.libraryManagementSystem.data.model.Book;
import com.library.libraryManagementSystem.data.model.Reader;
import com.library.libraryManagementSystem.data.repository.BookRepository;
import com.library.libraryManagementSystem.data.repository.ReaderRepository;
import com.library.libraryManagementSystem.web.exception.ItemDoesNotExist;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ReaderServiceImpl implements ReaderService {

    @Autowired
    ReaderRepository readerRepository;

    @Override
    public List<Reader> getAllReaders() {
        return readerRepository.findAll();
    }

    @Override
    public void deleteReaderById(Integer id) throws ItemDoesNotExist {
        try{
            readerRepository.deleteById(id);
        }catch (Exception e){
            throw new ItemDoesNotExist("The book with the id does not exist");
        }
    }

    @Override
    public Reader findReaderById(Integer id) throws ItemDoesNotExist {
        if(readerRepository.existsById(id)){
            return readerRepository.findById(id).get();
        }else{
            throw new ItemDoesNotExist("The book with the id does not exist");
        }
    }

    @Override
    public Reader updateReader(Reader reader) throws ReaderException {
        if(reader == null){
            throw new ReaderException("Please create a book");
        }
        return readerRepository.saveReader(reader);
    }

    @Override
    public Reader createReader(Reader reader) throws ReaderException {
        if(reader == null){
            throw new ReaderException("Please create a book");
        }
        return readerRepository.saveReader(reader);
    }

}
