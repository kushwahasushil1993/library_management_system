package com.demo.librarymanagement.library_management_system.services;

import com.demo.librarymanagement.library_management_system.model.BookEntity;
import com.demo.librarymanagement.library_management_system.model.BookRequest;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service("libraryManagmentServices")
public class LibraryManagmentServices {
    public BookEntity convertLibraryRecordDtoToEntity(BookRequest bookreq) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(bookreq, BookEntity.class);
    }
}
