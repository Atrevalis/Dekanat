package com.dekanat.dekanat.server.repository;

import com.dekanat.dekanat.server.entity.StudentCard;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentCardRepository extends JpaRepository<StudentCard, Integer> {
}