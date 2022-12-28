package com.dekanat.dekanat.server.repository;

import com.dekanat.dekanat.server.entity.Plan;
import com.dekanat.dekanat.server.entity.Semester;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface SemesterRepository extends JpaRepository<Semester, Integer> {
    List<Semester> findAll();
    Optional<Semester> findById(int id);

    List<Semester> findAllById(int id);

    List<Semester> findAllByPlanNumber(Plan plan);
}