package com.dekanat.dekanat.server.repository;

import com.dekanat.dekanat.server.entity.Semester;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SemesterRepository extends JpaRepository<Semester, Integer> {
}