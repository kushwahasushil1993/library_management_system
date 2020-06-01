package com.demo.librarymanagement.library_management_system.repo;

import com.demo.librarymanagement.library_management_system.model.PersonEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.websocket.server.PathParam;
import java.util.List;
import java.util.Optional;

@Repository
public interface ProcureBookRepo extends JpaRepository<PersonEntity, Integer> {
    List<PersonEntity> findByFirstName(String firstName);
    /*@Query("select * from personentity where firstname = :name")
    Optional<Object> findById(@Param("name") String firstName);*/
    void deleteByFirstName(String firstName);

    @Query(value = "select * from person_entity where bookissuedate >= :date", nativeQuery = true)
    List<PersonEntity> findBybookIssueDate(@Param("date") String date);
}
