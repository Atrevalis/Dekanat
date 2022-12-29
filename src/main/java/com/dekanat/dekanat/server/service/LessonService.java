package com.dekanat.dekanat.server.service;

import com.dekanat.dekanat.server.entity.Department;
import com.dekanat.dekanat.server.entity.Lesson;
import com.dekanat.dekanat.server.entity.Semester;
import com.dekanat.dekanat.server.repository.DepartmentRepository;
import com.dekanat.dekanat.server.repository.LessonRepository;
import com.dekanat.dekanat.server.repository.SemesterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class LessonService {

    @Autowired
    private LessonRepository lessonRepository;

    @Autowired
    private SemesterRepository semesterRepository;

    public void createLesson(String name, int lh, int labh,int ph, int control, String index, int semesterId) {
        Lesson lesson = new Lesson();
        lesson.setName(name);
        lesson.setLectureH(lh);
        lesson.setLaboratoryH(labh);
        lesson.setPractiseH(ph);
        lesson.setControl(control);
        lesson.setIndex(index);
        lesson.setSemester(semesterRepository.findById(semesterId).get());

        lessonRepository.save(lesson);
    }

    public void deleteLesson(Lesson lesson) {
        lessonRepository.delete(lesson);
    }

    public void updateLesson(String name, int lh, int labh, int ph, int control, String index) throws NoSuchElementException {

        Lesson lesson = lessonRepository.findAllByName(name).get(0);
        lesson.setName(name);
        lesson.setLectureH(lh);
        lesson.setLaboratoryH(labh);
        lesson.setPractiseH(ph);
        lesson.setControl(control);
        lesson.setIndex(index);

        lessonRepository.save(lesson);
    }

    public List<Lesson> findAllLesson(int semesterId){
        return lessonRepository.findAllBySemester(semesterRepository.findAllById(semesterId).get(0));
    }
    public Lesson findByName(String name){
        return lessonRepository.findAllByName(name).get(0);
    }

    static class Control{

        int ZACH = 0;
        int EX = 1;
    }
}
