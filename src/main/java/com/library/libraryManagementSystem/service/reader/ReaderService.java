package com.library.libraryManagementSystem.service.reader;

import com.library.libraryManagementSystem.data.exception.ReaderEntityException;
import com.library.libraryManagementSystem.data.model.Reader;
import com.library.libraryManagementSystem.data.exception.NoSuchElementException;

import java.util.List;

public interface ReaderService {
    public List<Reader> getAllReaders();

    public void deleteReaderById(Integer id) throws NoSuchElementException;

    public Reader findReaderById(Integer id) throws NoSuchElementException;

    public Reader updateReader(Reader reader) throws ReaderEntityException;

    public Reader createReader(Reader reader) throws ReaderEntityException;
}
