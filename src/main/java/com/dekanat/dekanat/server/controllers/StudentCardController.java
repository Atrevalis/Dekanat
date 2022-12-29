package com.dekanat.dekanat.server.controllers;

import com.dekanat.dekanat.server.entity.Speciality;
import com.dekanat.dekanat.server.entity.StudentCard;
import com.dekanat.dekanat.server.requestbody.StudentCardBody;
import com.dekanat.dekanat.server.service.PlanService;
import com.dekanat.dekanat.server.service.SpecialityService;
import com.dekanat.dekanat.server.service.StudentCardService;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.List;
@RestController
public class StudentCardController {

    @Autowired
    private StudentCardService studentCardService;

    @Autowired
    private SpecialityService specialityService;

    @PostMapping("/addStudentCard")
    public void create(@RequestBody StudentCardBody studentCardBody, HttpServletResponse response){
        studentCardService.createStudentCard(studentCardBody.getForm(), studentCardBody.getFinance(),
                studentCardBody.getStartDate(), studentCardBody.getEndDate(), studentCardBody.getGroupNumber(),
                studentCardBody.getSpecialityNumber(),studentCardBody.getId());
    }

    @PostMapping("/deleteStudentCard")
    public void delete(@RequestBody StudentCardBody studentCardBody, HttpServletResponse response){
        Speciality speciality = specialityService.findById(studentCardBody.getSpecialityNumber());
        StudentCard studentCard = new StudentCard(studentCardBody, speciality);
        studentCardService.deleteStudentCard(studentCard);
        response.setStatus(HttpServletResponse.SC_OK);
    }

    @PostMapping("/updateStudentCard")
    public void update(@RequestBody StudentCardBody studentCardBody,  HttpServletResponse response){
        studentCardService.updateStudentCard(studentCardBody.getForm(),studentCardBody.getFinance(),
                studentCardBody.getStartDate(), studentCardBody.getEndDate(), studentCardBody.getGroupNumber(),
                studentCardBody.getId());
    }

    @GetMapping("/listStudentCard")
    public @ResponseBody
    List<StudentCard> findAll(HttpServletResponse response){
        response.setStatus(HttpServletResponse.SC_OK);
        return studentCardService.findAll();
    }
}
