package com.example.codeBufferMasterClass.controller;

import com.example.codeBufferMasterClass.entity.Department;
import com.example.codeBufferMasterClass.error.DepartmentNotFoundException;
import com.example.codeBufferMasterClass.service.DepartmentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Locale;

@RestController
public class DepartmentController {
    @Autowired
    private DepartmentService departmentService;

//    for Logger
    private final Logger LOGGER = LoggerFactory.getLogger(DepartmentController.class);

    //for add data  -> http://localhost:8083/departments
//    {
//        "departmentName":"a",
//            "departmentAddress": "departmentAddress",
//            "departmentCode":"departmentCode"
//    }

    //@Valid is used  for validation


//    @RequestBody is used to take the input in the form of body

    @PostMapping("/departments")
    public Department saveDepartment(@Valid @RequestBody Department department ){
//        for logger
        LOGGER.info("Inside saveDepartment of DepartmentController");
        return departmentService.saveDepartment(department);
    }

    // for get data  -> http://localhost:8083/departments
    @GetMapping("/departments")
    public List<Department> fetchDepartmentList(){
//        for logger
        LOGGER.info("Inside fetchDepartmentList of DepartmentController");
        return departmentService.fetchDepartmentList();
    }

    // for find by id -> http://localhost:8083/departments/1
    @GetMapping("/departments/{id}")
    public Department fetchDepartmentById(@PathVariable("id") Long departmentId) throws DepartmentNotFoundException {
        return departmentService.fetchDepartmentById(departmentId);

    }
}

