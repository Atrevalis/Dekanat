package com.dekanat.dekanat.server.service;

import com.dekanat.dekanat.server.entity.Plan;
import com.dekanat.dekanat.server.entity.Semester;
import com.dekanat.dekanat.server.repository.PlanRepository;
import com.dekanat.dekanat.server.repository.SemesterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class SemesterService {

    @Autowired
    SemesterRepository semesterRepository;
    @Autowired
    private PlanRepository planRepository;

    public void createSemester(int number, String sDate, String eDate, int planId) throws ParseException {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate localDate = LocalDate.parse(sDate, formatter);

        Semester semester = new Semester();
        semester.setStartDate(localDate);
        localDate = LocalDate.parse(eDate, formatter);
        semester.setEndDate(localDate);
        semester.setPlanNumber(planRepository.findAllById(planId).get(0));

        semesterRepository.save(semester);
    }

    public void updateSemester(int number, String sDate, String eDate, int planId, int semesterId) throws NoSuchElementException {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate localDate = LocalDate.parse(sDate, formatter);

        Semester semester = semesterRepository.findById(semesterId).get();
        semester.setStartDate(localDate);
        localDate = LocalDate.parse(eDate, formatter);
        semester.setEndDate(localDate);
        semester.setPlanNumber(planRepository.findAllById(planId).get(0));

        semesterRepository.save(semester);
    }

    public void deleteSemester(Semester semester) {
        semesterRepository.delete(semester);
    }

    public List<Semester> findAllByPlan(int planId){
        return semesterRepository.findAllByPlanNumber(planRepository.findAllById(planId).get(0));
    }

}
