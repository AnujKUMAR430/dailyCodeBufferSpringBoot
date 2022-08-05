package com.springDataJpaCodeWithBuffer.springdatajpa.repository;

import com.springDataJpaCodeWithBuffer.springdatajpa.entity.Guardian;
import com.springDataJpaCodeWithBuffer.springdatajpa.entity.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class StudentRepositoryTest {
    // we want to test StudentRepository for that call StudentRepository and use @AutoWired because it's already a class whenever we call any class inside class then we need this @AutoWired Annotation

    @Autowired
    private StudentRepository studentRepository;

    // this is for test case that's why we use @Test
    // saveStudent() is used to saving the student
    @Test
    public void saveStudent(){
        Student student = Student.builder()
                .emailId("anuj57@gamil.com")
                .firstName("dgs")
                .lastName("dsf")
//                .guardianName("ggf")
//                .guardianEmail("gasdhjds@gamil.com")
//                .guardianMobile("84564676556")
                .build();
        studentRepository.save(student);
    }
// printAllStudent is used to print all the student present in list
    @Test
    public void printAllStudent(){
        List<Student> studentList = studentRepository.findAll();
        System.out.println("studentList = " + studentList);
    }

    //this test case is for print student List using guardian using Embeddable or embedded
    @Test
    public void saveStudentWithGuardian(){

        Guardian guardian =Guardian.builder()
                .email("jakjsd")
                .name("sunny")
                .mobile("5647657856")
                .build();

        Student student = Student.builder()
                .firstName("anuj")
                .lastName("bhardwaj")
                .emailId("hjashfa@gamil.com")
                .guardian(guardian)
                .build();
        studentRepository.save(student);

    }
// this test case for find by first name in student list
    @Test
    public void printStudentByFirstName(){
        List<Student> students = studentRepository.findByFirstName("anuj");
        studentRepository.findByFirstName("anuj");
        System.out.println("students = " + students);
    }

    // jpql query test
    @Test
    public void printGetStudentByEmailAddress(){
        Student student = studentRepository.getStudentByEmailAddress("anuj57@gmail.com");
        System.out.println("student = " + student);
    }
// this test case is for updating where the email address match then update this name for that we are using @Modifying and @Transactional Annotation
    @Test
    public void updateStudentNameByEmailIdTest(){
        studentRepository.updateStudentNameByEmailId("dgs anuj", "anuj57@gamil.com");
    }

}