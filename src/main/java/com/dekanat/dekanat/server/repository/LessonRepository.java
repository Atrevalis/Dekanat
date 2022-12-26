package com.dekanat.dekanat.server.repository;

import com.dekanat.dekanat.server.entity.Lesson;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LessonRepository extends JpaRepository<Lesson, Integer> {
}