package com.dekanat.dekanat.server.service;

import com.dekanat.dekanat.server.entity.Department;
import com.dekanat.dekanat.server.entity.Speciality;
import com.dekanat.dekanat.server.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;

    public void createDepartment(String departmentName) {
        Department department = new Department();
        department.setName(departmentName);

        departmentRepository.save(department);
    }

    public void updateDepartmentName(String name) throws NoSuchElementException {

        Department department = departmentRepository.findAllByName(name).get(0);
        department.setName(name);
        departmentRepository.save(department);
    }

    public void deleteDepartment(Department department) {
        departmentRepository.delete(department);
    }

    public List<Department> findAll(){
        return departmentRepository.findAll();
    }

}
