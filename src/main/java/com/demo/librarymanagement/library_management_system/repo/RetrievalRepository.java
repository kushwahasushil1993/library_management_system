package com.demo.librarymanagement.library_management_system.repo;

import com.demo.librarymanagement.library_management_system.model.BookEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface RetrievalRepository extends JpaRepository<BookEntity, Integer> {

}
