package com.springDataJpaCodeWithBuffer.springdatajpa.repository;

import com.springDataJpaCodeWithBuffer.springdatajpa.entity.Course;
import com.springDataJpaCodeWithBuffer.springdatajpa.entity.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class TeacherRepositoryTest {
    @Autowired
    private TeacherRepository teacherRepository;

    @Test
    public void saveTeacher() {

        Course courseCLanguage = Course.builder()
                .title("C++ programming language")
                .credit(9)
                .build();

        Course courseDba = Course.builder()
                .title("data base")
                .credit(6)
                .build();

        Teacher teacher = Teacher.builder()
                .firstName("Anshu")
                .lastName("sharma")
                .course(List.of(courseCLanguage, courseDba))
                .build();
        teacherRepository.save(teacher);
    }

}