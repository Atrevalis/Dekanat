package com.dekanat.dekanat.server.controllers;

import com.dekanat.dekanat.server.entity.Lesson;
import com.dekanat.dekanat.server.entity.Semester;
import com.dekanat.dekanat.server.entity.Speciality;
import com.dekanat.dekanat.server.requestbody.LessonBody;
import com.dekanat.dekanat.server.service.LessonService;
import com.dekanat.dekanat.server.service.PlanService;
import com.dekanat.dekanat.server.service.SemesterService;
import com.dekanat.dekanat.server.service.SpecialityService;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;
import java.util.List;

@RestController
public class LessonController {
    @Autowired
    private LessonService lessonService;

    @Autowired
    private SemesterService semesterService;

    @PostMapping("/addLesson")
    public void create(@RequestBody LessonBody lessonBody, HttpServletResponse response){
        lessonService.createLesson(lessonBody.getName(), lessonBody.getLectureH(), lessonBody.getLaboratoryH(),
                lessonBody.getPractiseH(), lessonBody.getControl(), lessonBody.getIndex(), lessonBody.getSemester());
    }

    @PostMapping("/deleteLesson")
    public void delete(@RequestBody LessonBody lessonBody, HttpServletResponse response){
        Semester semester = semesterService.findById(lessonBody.getSemester());
        Lesson lesson = new Lesson(lessonBody.getId(), lessonBody.getName(), lessonBody.getLectureH(), lessonBody.getPractiseH(),
                lessonBody.getLaboratoryH(), lessonBody.getControl(), lessonBody.getIndex(), semester);

        lessonService.deleteLesson(lesson);
        response.setStatus(HttpServletResponse.SC_OK);
    }

    @PostMapping("/updateLesson")
    public void update(@RequestBody LessonBody lessonBody, HttpServletResponse response){
        lessonService.updateLesson(lessonBody.getName(), lessonBody.getLectureH(), lessonBody.getLaboratoryH(),
                lessonBody.getPractiseH(), lessonBody.getControl(), lessonBody.getIndex());

    }

    @PostMapping("/listLesson")
    public @ResponseBody
    List<Lesson> findAllBySemester(@RequestBody LessonBody lessonBody, HttpServletResponse response){
        response.setStatus(HttpServletResponse.SC_OK);
        return lessonService.findAllLesson(lessonBody.getSemester());
    }
}
