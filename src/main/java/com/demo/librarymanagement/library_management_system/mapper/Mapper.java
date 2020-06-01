package com.demo.librarymanagement.library_management_system.mapper;

import com.demo.librarymanagement.library_management_system.model.PersonEntity;
import com.demo.librarymanagement.library_management_system.model.PersonRequest;
import com.demo.librarymanagement.library_management_system.model.PersonResponse;

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
}
