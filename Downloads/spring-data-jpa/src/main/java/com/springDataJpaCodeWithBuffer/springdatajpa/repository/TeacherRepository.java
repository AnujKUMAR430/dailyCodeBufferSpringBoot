package com.springDataJpaCodeWithBuffer.springdatajpa.repository;

import com.springDataJpaCodeWithBuffer.springdatajpa.entity.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeacherRepository extends JpaRepository<Teacher, Long> {
}
