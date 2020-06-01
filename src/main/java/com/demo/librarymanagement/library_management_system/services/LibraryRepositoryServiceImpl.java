package com.demo.librarymanagement.library_management_system.services;

import com.demo.librarymanagement.library_management_system.model.BookEntity;
import com.demo.librarymanagement.library_management_system.repo.LibraryManagementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component("libraryRepositoryServiceImpl")
public class LibraryRepositoryServiceImpl implements LibraryRepositoryService{
    @Autowired
    LibraryManagementRepository libraryManagementRepository;

    @Override
    public BookEntity insertRecord(BookEntity bookEntity) {
        libraryManagementRepository.save(bookEntity);
        return bookEntity;
    }

    @Override
    public List<BookEntity> listAll() {
        List<BookEntity> bookEntity = new ArrayList<>();
        libraryManagementRepository.findAll().forEach(bookEntity::add);
        return bookEntity;
    }
}
