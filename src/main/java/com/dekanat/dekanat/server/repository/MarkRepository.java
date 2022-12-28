package com.dekanat.dekanat.server.repository;

import com.dekanat.dekanat.server.entity.Lesson;
import com.dekanat.dekanat.server.entity.Mark;
import com.dekanat.dekanat.server.entity.StudentCard;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MarkRepository extends JpaRepository<Mark, Integer> {
    List<Mark> findAll();
    List<Mark> findByMark(int mark);

    List<Mark> findAllByStudentNumberAndLesson(StudentCard studentCard, Lesson lesson);
    List<Mark> findAllByStudentNumber(StudentCard studentCard);
}