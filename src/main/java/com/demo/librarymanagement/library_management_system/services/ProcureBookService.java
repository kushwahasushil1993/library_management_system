package com.demo.librarymanagement.library_management_system.services;

import com.demo.librarymanagement.library_management_system.exception.BookNotFoundException;
import com.demo.librarymanagement.library_management_system.mapper.Mapper;
import com.demo.librarymanagement.library_management_system.model.*;
import com.demo.librarymanagement.library_management_system.repo.BookRepo;
import com.demo.librarymanagement.library_management_system.repo.ProcureBookRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Collectors;

@Service
public class ProcureBookService {

    @Autowired
    private ProcureBookRepo procureBookRepo;
    @Autowired
    private BookRepo bookRepo;

    public PersonResponse reserveBook(PersonRequest request) {
        Optional<BookEntity> bookRepoById = bookRepo.findById(request.getBook());
        AtomicReference<PersonResponse> response = null;
        if (bookRepoById.isPresent()){
            PersonEntity person = Mapper.requestToEntity(request);
            PersonEntity personEntity = procureBookRepo.save(person);
            return Mapper.entityToResponse(personEntity);
        }
        else{
            throw new BookNotFoundException(request.getBook() + " provided book is not availbale. Please select valid book");
        }
    }

    public List<PersonBookResponse> reserveBookDetails(String firstName) {
        List<PersonEntity> personEntityList = procureBookRepo.findByFirstName(firstName);
        List<Optional<BookEntity>> books = personEntityList.stream().map(personEntity -> bookRepo.findById(personEntity.getBook())).collect(Collectors.toList());
        return personEntityList
                .stream()
                    .map(personEntity -> Mapper.entityToResponseForGetAll(personEntity, books))
                        .collect(Collectors.toList());
    }

    public PersonResponse reserveBookUpdate(PersonRequest request, String firstName) {
        PersonEntity personEntity = Mapper.requestToEntity(request);
        return Mapper.entityToResponse(procureBookRepo.save(personEntity));
    }

    public String reserveBookDelete(int id) {
        procureBookRepo.deleteById(id);
        return "Person Deleted Successfully";
    }
}
