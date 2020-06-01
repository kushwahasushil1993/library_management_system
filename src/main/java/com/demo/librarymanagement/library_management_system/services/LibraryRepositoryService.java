package com.demo.librarymanagement.library_management_system.services;

import com.demo.librarymanagement.library_management_system.model.BookEntity;

import java.util.List;

public interface LibraryRepositoryService {
    BookEntity insertRecord(BookEntity bookEntity);
    List<BookEntity> listAll();
}
