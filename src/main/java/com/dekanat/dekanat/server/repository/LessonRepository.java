package com.dekanat.dekanat.server.repository;

import com.dekanat.dekanat.server.entity.Lesson;
import com.dekanat.dekanat.server.entity.Semester;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface LessonRepository extends JpaRepository<Lesson, Integer> {
    List<Lesson> findAll();
    Optional<Lesson> findById(int id);

    List<Lesson> findAllByName(String name);

    List<Lesson> findAllBySemester(Semester semester);
}
