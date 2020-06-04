package com.demo.librarymanagement.library_management_system.mapper;

import com.demo.librarymanagement.library_management_system.model.*;

import java.lang.Integer;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Mapper {

    public static PersonEntity requestToEntity(PersonRequest request){
        PersonEntity personEntity = new PersonEntity();
        personEntity.setBook(request.getBook());
        personEntity.setBookIssueDate(request.getBookIssueDate());
        personEntity.setBookReturnDate(request.getBookReturnDate());
        personEntity.setContactInfo(request.getContactInfo());
        personEntity.setEmail(request.getEmail());
        personEntity.setFirstName(request.getFirstName());
        personEntity.setLastName(request.getLastName());
        personEntity.setPersonId(request.getPersonId());
        return personEntity;
    }

    private static List<Integer> getBook(List<BookRequest> book) {
        List<java.lang.Integer> bookEntityList = new ArrayList<>();
        for (BookRequest request: book){
            bookEntityList.add(request.getId());
        }
        return bookEntityList;
    }

    public static PersonResponse entityToResponse(PersonEntity personEntity){
        PersonResponse response = new PersonResponse();
        response.setBook(personEntity.getBook());
        response.setBookIssueDate(personEntity.getBookIssueDate());
        response.setBookReturnDate(personEntity.getBookReturnDate());
        response.setContactInfo(personEntity.getContactInfo());
        response.setEmail(personEntity.getEmail());
        response.setFirstName(personEntity.getFirstName());
        response.setLastName(personEntity.getLastName());
        response.setPersonId(personEntity.getPersonId());
        return response;
    }

    public static PersonBookResponse entityToResponseForGetAll(PersonEntity personEntity, List<Optional<BookEntity>> books) {
        PersonBookResponse response = new PersonBookResponse();
        response.setBook(getBookDetails(books));
        response.setBookIssueDate(personEntity.getBookIssueDate());
        response.setBookReturnDate(personEntity.getBookReturnDate());
        response.setContactInfo(personEntity.getContactInfo());
        response.setEmail(personEntity.getEmail());
        response.setFirstName(personEntity.getFirstName());
        response.setLastName(personEntity.getLastName());
        response.setPersonId(personEntity.getPersonId());
        return response;
    }

    private static List<BookResponse> getBookDetails(List<Optional<BookEntity>> books) {
        List<BookResponse> bookResponses = new ArrayList<>();
        for (Optional<BookEntity> entity: books){
            BookResponse response = new BookResponse();
            response.setAuthorName(entity.get().getAuthorName());
            response.setBookName(entity.get().getBookName());
            bookResponses.add(response);
        }
        return bookResponses;
    }
}
