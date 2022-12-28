package com.dekanat.dekanat.server.service;

import com.dekanat.dekanat.server.entity.Department;
import com.dekanat.dekanat.server.entity.Plan;
import com.dekanat.dekanat.server.repository.DepartmentRepository;
import com.dekanat.dekanat.server.repository.PlanRepository;
import com.dekanat.dekanat.server.repository.SpecialityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class PlanService {

    @Autowired
    private PlanRepository planRepository;

    @Autowired
    private SpecialityRepository specialityRepository;

    public void createPlan(int id, int hours, String sDate, String eDate, String specialityName) throws ParseException {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate localDate = LocalDate.parse(sDate, formatter);

        Plan plan = new Plan();
        plan.setStartDate(localDate);
        localDate = LocalDate.parse(eDate, formatter);
        plan.setEndDate(localDate);
        plan.setHours(hours);
        plan.setId(id);
        plan.setSpecialityNumber(specialityRepository.findAllByName(specialityName).get(0));

        planRepository.save(plan);
    }

    public void updatePlanName(int id, int oldId, int hour, String eDate, String sDate) throws NoSuchElementException {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate localDate = LocalDate.parse(sDate, formatter);

        Plan plan = planRepository.findAllById(oldId).get(0);
        plan.setId(id);
        plan.setHours(hour);
        plan.setStartDate(localDate);
        localDate = LocalDate.parse(eDate, formatter);
        plan.setEndDate(localDate);
        planRepository.save(plan);
    }

    public void deletePlan(Plan plan) {
        planRepository.delete(plan);
    }

    public List<Plan> findAllByPlan(String specialityName){
        return planRepository.findAllBySpecialityNumber(specialityRepository.findAllByName(specialityName).get(0));
    }

}
