package com.library.libraryManagementSystem.service.reader;

import com.library.libraryManagementSystem.data.exception.ReaderEntityException;
import com.library.libraryManagementSystem.data.model.Reader;
import com.library.libraryManagementSystem.data.repository.ReaderRepository;
import com.library.libraryManagementSystem.data.exception.NoSuchElementException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ReaderServiceImpl implements ReaderService {

    @Autowired
    ReaderRepository readerRepository;

    @Override
    public List<Reader> getAllReaders() {
        return readerRepository.findAll();
    }

    @Override
    public void deleteReaderById(Integer id) throws NoSuchElementException {
        try{
            readerRepository.deleteById(id);
        }catch (Exception e){
            throw new NoSuchElementException("The book with the id does not exist");
        }
    }

    @Override
    public Reader findReaderById(Integer id) throws NoSuchElementException {
        Reader reader = readerRepository.findById(id).orElse(null);
        if(reader != null){
            return reader;
        }else{
            throw new NoSuchElementException("The book with the id does not exist");
        }
    }

    @Override
    public Reader updateReader(Reader reader) throws ReaderEntityException {
        if(reader == null){
            throw new ReaderEntityException("Please create a book");
        }
        return readerRepository.saveReader(reader);
    }

    @Override
    public Reader createReader(Reader reader) throws ReaderEntityException {
        if(reader == null){
            throw new ReaderEntityException("Please create a book");
        }
        return readerRepository.saveReader(reader);
    }

}
