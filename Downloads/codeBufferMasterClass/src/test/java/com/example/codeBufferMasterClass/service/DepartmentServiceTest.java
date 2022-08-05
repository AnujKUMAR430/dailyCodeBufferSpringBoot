package com.example.codeBufferMasterClass.service;

import com.example.codeBufferMasterClass.entity.Department;
import com.example.codeBufferMasterClass.repository.DepartmentRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.*;
// this is for service layer unit testing
@SpringBootTest
class DepartmentServiceTest {
    @Autowired
    private DepartmentService departmentService;

    @MockBean
    private DepartmentRepository departmentRepository;

    @BeforeEach
    void setUp() {
//        Department department = Department.Builder().departmentName("IT")
//                .departmentAddress("ahmadabad")
//                .departmentCode("IT-007")
//                .departmentId(1L)
//                .build();
//        Mockito.when(departmentRepository.findByDepartmentIgnoreCase("IT"))
//                .thenReturn(department);
    }
    @Test
    public void whenValidDepartmentName_thenDepartmentShouldFound(){
        String departmentName = "IT";
        Department found = departmentService.fetchDepartmentByName(departmentName);

    }
}