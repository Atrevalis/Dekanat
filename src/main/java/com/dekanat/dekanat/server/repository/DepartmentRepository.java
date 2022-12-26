package com.dekanat.dekanat.server.repository;

import com.dekanat.dekanat.server.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Department, Integer> {
}