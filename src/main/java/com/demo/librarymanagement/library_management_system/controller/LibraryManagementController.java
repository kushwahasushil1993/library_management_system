package com.demo.librarymanagement.library_management_system.controller;


import com.demo.librarymanagement.library_management_system.model.BookEntity;
import com.demo.librarymanagement.library_management_system.model.BookRequest;
import com.demo.librarymanagement.library_management_system.model.BookResponse;
import com.demo.librarymanagement.library_management_system.services.LibraryManagmentServices;
import com.demo.librarymanagement.library_management_system.services.LibraryRepositoryService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/book")
public class LibraryManagementController {

    @Autowired
    private LibraryManagmentServices libraryManagmentServices;

    @Autowired
    private LibraryRepositoryService libraryRepositoryService;

    @GetMapping(value = "/")
    public ResponseEntity<String> librarybook() {
        return new ResponseEntity<>("Welcome to the library management system!!", HttpStatus.OK);

    }

    @PostMapping(value = "/library/createbook")
    public ResponseEntity<BookResponse> insertnewrecord(@Valid @RequestBody BookRequest record,
                                                        HttpServletRequest request, HttpServletResponse response) {

        BookResponse bookResponse = null;
        if (record != null && record.getRequestType() != null && !record.getRequestType().isEmpty()
                && record.getRequestType().equalsIgnoreCase("new")) {
            boolean isRecordExist = checkIfRecordExists(record);
            if (isRecordExist) {
                bookResponse = new BookResponse();
                //bookResponse.setStatus(HttpStatus.CONFLICT.name());
                bookResponse.setMessage("Record already exists");
                bookResponse.setStatus(HttpStatus.BAD_REQUEST.getReasonPhrase());
                bookResponse.setErrorCode("500");
                
            } else if (!isRecordExist) {
                bookResponse = new BookResponse();
                boolean isRecordSaved = false;
                BookEntity bookEntity = null;
                try {
                    bookEntity = libraryManagmentServices.convertLibraryRecordDtoToEntity(record);
                    libraryRepositoryService.insertRecord(bookEntity);
                    isRecordSaved = true;
                } catch (Exception e) {

                    bookResponse.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.name());
                    bookResponse.setMessage("Error saving Library book");
                    return new ResponseEntity<>(bookResponse, HttpStatus.INTERNAL_SERVER_ERROR);
                }
                if (isRecordSaved) {
                    bookResponse.setStatus(HttpStatus.OK.name());
                    bookResponse.setMessage("Inserted the library book sucessfully");
                    ModelMapper mapper = new ModelMapper();
                    mapper.map(bookEntity, bookResponse);
                }
            }
        } else {
            bookResponse = new BookResponse();
            bookResponse.setStatus(HttpStatus.BAD_REQUEST.name());
            bookResponse.setMessage("Invalid Request type");
        }
        return new ResponseEntity<>(bookResponse, HttpStatus.OK);
    }

    private boolean checkIfRecordExists(BookRequest record) {
        List<BookEntity> listAll = libraryRepositoryService.listAll();
        for (BookEntity listItem : listAll) {
            if (record.getAuthorName().equals(listItem.getAuthorName())
                    && record.getBookName().equals(listItem.getBookName())) {
                return true;

            }

        }
        return false;
    }
}

