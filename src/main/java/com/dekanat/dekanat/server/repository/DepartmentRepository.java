package com.dekanat.dekanat.server.repository;

import com.dekanat.dekanat.server.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DepartmentRepository extends JpaRepository<Department, Integer> {
    List<Department> findAll();
    List<Department> findById(int id);
}