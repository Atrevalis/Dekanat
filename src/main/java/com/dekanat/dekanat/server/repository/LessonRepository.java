package com.dekanat.dekanat.server.repository;

import com.dekanat.dekanat.server.entity.Lesson;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LessonRepository extends JpaRepository<Lesson, Integer> {
    List<Lesson> findAll();
    List<Lesson> findById(int id);
}
