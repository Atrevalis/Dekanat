package com.dekanat.dekanat.server.repository;

import com.dekanat.dekanat.server.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface DepartmentRepository extends JpaRepository<Department, Integer> {
    List<Department> findAll();
    Optional<Department> findById(int id);
    List<Department> findAllByName(String name);
}