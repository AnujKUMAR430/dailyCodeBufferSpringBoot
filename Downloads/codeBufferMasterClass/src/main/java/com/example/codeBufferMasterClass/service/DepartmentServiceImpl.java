package com.example.codeBufferMasterClass.service;

import com.example.codeBufferMasterClass.entity.Department;
import com.example.codeBufferMasterClass.error.DepartmentNotFoundException;
import com.example.codeBufferMasterClass.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DepartmentServiceImpl implements DepartmentService{

    @Autowired
    private DepartmentRepository departmentRepository;
    @Override
    public Department saveDepartment(Department department) {
        return departmentRepository.save(department);
    }

    @Override
    public List<Department> fetchDepartmentList() {
        return departmentRepository.findAll();
    }

    @Override
    public Department fetchDepartmentById(Long departmentId) throws DepartmentNotFoundException {
       // for fetching(get) data
//        return departmentRepository. findById(departmentId).get();

        // this is used for Exception handing or get data
        Optional<Department> department =
                departmentRepository. findById(departmentId);
        if(!department.isPresent()){
            throw new DepartmentNotFoundException("Department not available");
        }
        return department.get();
    }

    @Override
    public Department fetchDepartmentByName(String departmentName) {
        return null;
    }
}
