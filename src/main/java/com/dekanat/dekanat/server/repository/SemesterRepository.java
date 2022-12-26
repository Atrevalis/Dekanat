package com.dekanat.dekanat.server.repository;

import com.dekanat.dekanat.server.entity.Semester;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SemesterRepository extends JpaRepository<Semester, Integer> {
    List<Semester> findAll();
    List<Semester> findById(int id);
}