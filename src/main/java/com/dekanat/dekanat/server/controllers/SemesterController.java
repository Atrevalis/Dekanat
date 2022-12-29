package com.dekanat.dekanat.server.controllers;

import com.dekanat.dekanat.server.Utils.Time;
import com.dekanat.dekanat.server.entity.Semester;
import com.dekanat.dekanat.server.entity.Speciality;
import com.dekanat.dekanat.server.requestbody.SemesterBody;
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
public class SemesterController {
    @Autowired
    private SemesterService semesterService;

    @Autowired
    private PlanService planService;

    @PostMapping("/addSemester")
    public void create(@RequestBody SemesterBody semesterBody, HttpServletResponse response) throws ParseException {
        semesterService.createSemester(semesterBody.getNumber(),semesterBody.getStartDate(),
                semesterBody.getEndDate(), semesterBody.getPlanNumber());
    }

    @PostMapping("/deleteSemester")
    public void delete(@RequestBody SemesterBody semesterBody, HttpServletResponse response){

        Semester semester = new Semester(semesterBody.getId(), semesterBody.getNumber(),
                Time.getLocalDate(semesterBody.getStartDate()), Time.getLocalDate(semesterBody.getEndDate()),
                planService.findById(semesterBody.getId()));
        semesterService.deleteSemester(semester);
        response.setStatus(HttpServletResponse.SC_OK);
    }

    @PostMapping("/updateSemester")
    public void update(@RequestBody SemesterBody semesterBody, HttpServletResponse response){
        semesterService.updateSemester(semesterBody.getNumber(), semesterBody.getStartDate(),
                semesterBody.getEndDate(), semesterBody.getPlanNumber(), semesterBody.getId());
    }

    @PostMapping("/listSemester")
    public @ResponseBody
    List<Semester> findAllByPlan(@RequestBody SemesterBody semesterBody, HttpServletResponse response) {
        response.setStatus(HttpServletResponse.SC_OK);
        return semesterService.findAllByPlan(semesterBody.getPlanNumber());
    }
}
