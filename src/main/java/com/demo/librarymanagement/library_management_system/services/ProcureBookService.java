package com.demo.librarymanagement.library_management_system.services;

import com.demo.librarymanagement.library_management_system.exception.BookNotFoundException;
import com.demo.librarymanagement.library_management_system.mapper.Mapper;
import com.demo.librarymanagement.library_management_system.model.BookEntity;
import com.demo.librarymanagement.library_management_system.model.PersonEntity;
import com.demo.librarymanagement.library_management_system.model.PersonRequest;
import com.demo.librarymanagement.library_management_system.model.PersonResponse;
import com.demo.librarymanagement.library_management_system.repo.BookRepo;
import com.demo.librarymanagement.library_management_system.repo.ProcureBookRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProcureBookService {

    /*@Autowired
    private MapperManager mapper;*/
    @Autowired
    private ProcureBookRepo procureBookRepo;
    @Autowired
    private BookRepo bookRepo;

    public PersonResponse reserveBook(PersonRequest request) {
        BookEntity isAvailabe = bookRepo.findByBookName(request.getBook().get(0).getBookName());
        if (isAvailabe.getBookName() != null){
            PersonEntity person = Mapper.requestToEntity(request);
            PersonEntity personEntity = procureBookRepo.save(person);
            return Mapper.entityToResponse(personEntity);
        }
        else{
            throw new BookNotFoundException(request.getBook() + " provided book is not availbale. Please select valid book");
        }
    }

    public List<PersonResponse> reserveBookDetails(String firstName) {
        List<PersonEntity> personEntityList = procureBookRepo.findByFirstName(firstName);
        return personEntityList
                .stream()
                    .map(personEntity -> Mapper.entityToResponse(personEntity))
                        .collect(Collectors.toList());
    }

    public PersonResponse reserveBookUpdate(PersonRequest request, String firstName) {
        PersonEntity personEntity = Mapper.requestToEntity(request);
        return Mapper.entityToResponse(procureBookRepo.save(personEntity));
    }

    public String reserveBookDelete(String firstName) {
        procureBookRepo.deleteByFirstName(firstName);
        return "Person Deleted Successfully";
    }
}
