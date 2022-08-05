package com.springDataJpaCodeWithBuffer.springdatajpa.repository;

import com.springDataJpaCodeWithBuffer.springdatajpa.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


// we are also create a test case for that if you want to check then goto StudentRepositoryTest class and check how its implemented
@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
    //this is method we created for find by first name in student list
    public List<Student> findByFirstName(String firstName);

    //JPQL query
    @Query("select s from Student s where s.emailId = ?1")
    Student getStudentByEmailAddress(String emailId);

    @Modifying
    @Transactional
    @Query(
            value = "update tbl_student set first_name = ?1 where email_address = ?2",
            nativeQuery = true
    )
    int updateStudentNameByEmailId(String firstName, String emailId);



}
