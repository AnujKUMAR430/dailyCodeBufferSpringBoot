package com.example.codeBufferMasterClass.service;

import com.example.codeBufferMasterClass.entity.Department;
import com.example.codeBufferMasterClass.error.DepartmentNotFoundException;

import java.util.List;

public interface DepartmentService {
   public Department saveDepartment(Department department);

   public List<Department> fetchDepartmentList();

   public Department fetchDepartmentById(Long departmentId) throws DepartmentNotFoundException;

   Department fetchDepartmentByName(String departmentName);
}
