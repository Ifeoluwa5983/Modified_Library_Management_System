package com.library.libraryManagementSystem.service.reader;

import com.library.libraryManagementSystem.data.exception.ReaderException;
import com.library.libraryManagementSystem.data.model.Reader;
import com.library.libraryManagementSystem.data.exception.ItemDoesNotExist;

import java.util.List;

public interface ReaderService {
    public List<Reader> getAllReaders();

    public void deleteReaderById(Integer id) throws ItemDoesNotExist;

    public Reader findReaderById(Integer id) throws ItemDoesNotExist;

    public Reader updateReader(Reader reader) throws ReaderException;

    public Reader createReader(Reader reader) throws ReaderException;
}
