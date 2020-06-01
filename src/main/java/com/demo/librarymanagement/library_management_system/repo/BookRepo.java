package com.demo.librarymanagement.library_management_system.repo;

import com.demo.librarymanagement.library_management_system.model.BookEntity;
import com.demo.librarymanagement.library_management_system.model.PersonEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepo extends JpaRepository<BookEntity, Integer> {
    BookEntity findByBookName(String bookName);
}
