package com.library.libraryManagementSystem.data.repository;

import com.library.libraryManagementSystem.data.model.Library;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LibraryRepository extends JpaRepository<Library, Integer> {

}
