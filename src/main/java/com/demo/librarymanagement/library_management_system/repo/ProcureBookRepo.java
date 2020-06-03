package com.demo.librarymanagement.library_management_system.repo;

import com.demo.librarymanagement.library_management_system.model.PersonEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProcureBookRepo extends JpaRepository<PersonEntity, Integer> {
    List<PersonEntity> findByFirstName(String firstName);

    int deleteByFirstName(String firstName);

    @Query(value = "select * from person_entity where bookissuedate >= :date", nativeQuery = true)
    List<PersonEntity> findBybookIssueDate(@Param("date") String date);

    PersonEntity findByBookId(int book);
}
