package com.dekanat.dekanat.server.service;

import com.dekanat.dekanat.server.entity.Department;
import com.dekanat.dekanat.server.entity.Lesson;
import com.dekanat.dekanat.server.entity.Mark;
import com.dekanat.dekanat.server.entity.StudentCard;
import com.dekanat.dekanat.server.repository.DepartmentRepository;
import com.dekanat.dekanat.server.repository.LessonRepository;
import com.dekanat.dekanat.server.repository.MarkRepository;
import com.dekanat.dekanat.server.repository.StudentCardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MarkService {

    @Autowired
    private MarkRepository markRepository;

    @Autowired
    private LessonRepository lessonRepository;

    @Autowired
    StudentCardRepository studentCardRepository;

    public void createMark(int thatMark, String lessonName, int numberSB){
        Mark mark = new Mark();
        mark.setMark(thatMark);

        mark.setLesson(lessonRepository.findAllByName(lessonName).get(0));
        mark.setStudentNumber(studentCardRepository.findAllById(numberSB).get(0));

        markRepository.save(mark);
    }

    public void deleteMark(Mark mark) {
        markRepository.delete(mark);
    }

    public void updateMark(int thatMark, StudentCard studentCard, Lesson lesson){
        Mark mark = markRepository.findAllByStudentNumberAndLesson(studentCard, lesson).get(0);
        mark.setMark(thatMark);

        markRepository.save(mark);
    }

   public List<Mark> findAllByStudent(StudentCard studentCard){
        return markRepository.findAllByStudentNumber(studentCard);
    }
}
