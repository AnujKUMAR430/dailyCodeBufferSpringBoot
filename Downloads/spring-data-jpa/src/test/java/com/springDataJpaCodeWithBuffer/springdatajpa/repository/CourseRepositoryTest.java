package com.springDataJpaCodeWithBuffer.springdatajpa.repository;

import com.springDataJpaCodeWithBuffer.springdatajpa.entity.Course;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;

@SpringBootTest
class CourseRepositoryTest {
    @Autowired
    private CourseRepository courseRepository;

    @Test
    public void printCourses(){
        List<Course> courses =courseRepository.findAll();
        System.out.println("courses = " + courses);

    }

    @Test
    public void findAllPagination(){
        Pageable firstPageWithTwoRecords =
                PageRequest.of(0,2);

        List<Course> courses = courseRepository.findAll(firstPageWithTwoRecords).getContent();

        System.out.println("courses = " + courses);

// these are some methods
        long totalElement = courseRepository.findAll(firstPageWithTwoRecords).getTotalElements();
        System.out.println("totalElement = " + totalElement);


        long totalPages = courseRepository.findAll(firstPageWithTwoRecords).getTotalPages();
        System.out.println("totalPages = " + totalPages);

    }
    // example of sorting method
    @Test
    public void findAllSorting(){
        Pageable sortByTitle = PageRequest.of(0,2, Sort.by("title"));

        Pageable sortByCreditDesc = PageRequest.of(0,2, Sort.by("credit").descending());

List<Course> courses = courseRepository.findAll(sortByTitle).getContent();
        System.out.println("courses = " + courses);
    }

    @Test
    public void printFindByTitleContaining(){
        Pageable firstPageTenRecords =
                PageRequest.of(0,2);

        List<Course> courses = courseRepository.findByTitleContaining("a", firstPageTenRecords).getContent();
        System.out.println("courses = " + courses);
    }
//    @Test
//    public void saveCourseWithStudentAndTeacher(){
//        Teacher teacher = Teacher.builder()
//                .firstName("manish")
//                .lastName("sir")
//                .build();
//
//        Student student =Student.builder()
//                .firstName("amit")
//                .lastName("sunar")
//                .emailId("anikait@gamil.com")
//                .build();
//
//
//        Course course = Course.builder()
//                .title("oops")
//                .credit(8)
//                .teacher(teacher)
//                .build();
//        course.addStudent(student);
//        courseRepository.save(course);
//    }


}