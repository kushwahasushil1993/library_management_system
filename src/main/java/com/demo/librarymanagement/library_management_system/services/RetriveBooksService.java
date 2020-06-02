package com.demo.librarymanagement.library_management_system.services;

import com.demo.librarymanagement.library_management_system.model.BookEntity;
import com.demo.librarymanagement.library_management_system.repo.BookRepo;
import com.demo.librarymanagement.library_management_system.repo.RetrievalRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;

public class RetriveBooksService {

    @Autowired
    public RetrievalRepository retrievalRepository;

    public ArrayList<BookEntity> retriveBooksByName(String bookNameOrAuthorName) {
        ArrayList<BookEntity> allBooks = (ArrayList<BookEntity>) retrievalRepository.findAll();
        ArrayList<BookEntity> filteredBooks = new ArrayList<>();
        if(!allBooks.isEmpty()) {
            for (BookEntity bookEntity : allBooks) {
                if(bookEntity.getAuthorName().equalsIgnoreCase(bookNameOrAuthorName) ||
                        bookEntity.getBookName().equalsIgnoreCase(bookNameOrAuthorName))
                    filteredBooks.add(bookEntity);
            }
        }
        return filteredBooks;
    }
}
