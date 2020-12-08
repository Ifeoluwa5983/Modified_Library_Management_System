package com.library.libraryManagementSystem.service.reader;

import com.library.libraryManagementSystem.data.exception.ExceptionInReaderEntity;
import com.library.libraryManagementSystem.data.model.Reader;
import com.library.libraryManagementSystem.data.repository.ReaderRepository;
import com.library.libraryManagementSystem.data.exception.ItemDoesNotExist;
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
    public void deleteReaderById(Integer id) throws ItemDoesNotExist {
        try{
            readerRepository.deleteById(id);
        }catch (Exception e){
            throw new ItemDoesNotExist("The book with the id does not exist");
        }
    }

    @Override
    public Reader findReaderById(Integer id) throws ItemDoesNotExist {
        Reader reader = readerRepository.findById(id).orElse(null);
        if(reader != null){
            return reader;
        }else{
            throw new ItemDoesNotExist("The book with the id does not exist");
        }
    }

    @Override
    public Reader updateReader(Reader reader) throws ExceptionInReaderEntity {
        if(reader == null){
            throw new ExceptionInReaderEntity("Please create a book");
        }
        return readerRepository.saveReader(reader);
    }

    @Override
    public Reader createReader(Reader reader) throws ExceptionInReaderEntity {
        if(reader == null){
            throw new ExceptionInReaderEntity("Please create a book");
        }
        return readerRepository.saveReader(reader);
    }

}
