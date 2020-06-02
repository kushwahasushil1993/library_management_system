package com.demo.librarymanagement.library_management_system.controller;

import com.demo.librarymanagement.library_management_system.model.BookEntity;
import com.demo.librarymanagement.library_management_system.repo.RetrievalRepository;
import com.demo.librarymanagement.library_management_system.services.RetriveBooksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@RequestMapping("/book")
public class RetriveBooksController {

    @Autowired
    public RetriveBooksService retriveBooksService;

    @Autowired
    public RetrievalRepository retrievalRepository;

    @GetMapping(value = "/retriveBooksByName/{BookNameOrAuthorName}")
    public ArrayList<BookEntity> retriveRecords(@PathVariable String BookNameOrAuthorName){
        ArrayList<BookEntity> availableBooks = retriveBooksService.retriveBooksByName(BookNameOrAuthorName);
        return availableBooks;
    }

    @GetMapping(value = "/retriveAllBooks")
    public java.util.List<BookEntity> retriveAllBooks(){
        return retrievalRepository.findAll();
    }

}
