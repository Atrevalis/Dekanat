package com.dekanat.dekanat.server.controllers;

import com.dekanat.dekanat.server.entity.Lesson;
import com.dekanat.dekanat.server.entity.Mark;
import com.dekanat.dekanat.server.entity.Speciality;
import com.dekanat.dekanat.server.entity.StudentCard;
import com.dekanat.dekanat.server.requestbody.MarkBody;
import com.dekanat.dekanat.server.service.*;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;
import java.util.List;

@RestController
public class MarkController {
    @Autowired
    private MarkService markService;

    @Autowired
    private LessonService lessonService;

    @Autowired
    private StudentCardService studentCardService;

    @PostMapping("/addMark")
    public void create(@RequestBody MarkBody markBody, HttpServletResponse response){
        markService.createMark(markBody.getMark(),markBody.getLesson(),markBody.getStudentNumber());
    }

    @PostMapping("/deleteMark")
    public void delete(@RequestBody MarkBody markBody, HttpServletResponse response){
        Lesson lesson = lessonService.findByName(markBody.getLesson());
        StudentCard studentCard = studentCardService.findById(markBody.getStudentNumber());
        Mark mark = new Mark(markBody.getId(),markBody.getMark(),lesson,studentCard);
        markService.deleteMark(mark);
        response.setStatus(HttpServletResponse.SC_OK);
    }

    @PostMapping("/updateMark")
    public void update(@RequestBody MarkBody markBody, HttpServletResponse response){
        Lesson lesson = lessonService.findByName(markBody.getLesson());
        StudentCard studentCard = studentCardService.findById(markBody.getStudentNumber());
        markService.updateMark(markBody.getMark(),studentCard, lesson);
    }

    @PostMapping("/listMark")
    public @ResponseBody
    List<Mark> findAllByStudent(@RequestBody MarkBody markBody, HttpServletResponse response){
        response.setStatus(HttpServletResponse.SC_OK);
        return markService.findAllByStudent(studentCardService.findById(markBody.getStudentNumber()));
    }
}
