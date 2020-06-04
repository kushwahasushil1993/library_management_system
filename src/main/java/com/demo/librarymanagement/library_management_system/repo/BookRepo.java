package com.demo.librarymanagement.library_management_system.repo;

import com.demo.librarymanagement.library_management_system.model.BookEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface BookRepo extends JpaRepository<BookEntity, java.lang.Integer> {

    @Query(value = "SELECT * FROM BOOK_ENTITY where bookname=:bookname", nativeQuery = true)
    BookEntity findByBookName(@Param("bookname") String bookName);
}
