package com.demo.librarymanagement.library_management_system.repo;
import com.demo.librarymanagement.library_management_system.model.BookEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

@Component("libraryManagementRepository")
public interface LibraryManagementRepository  extends CrudRepository<BookEntity,Integer> {

}
