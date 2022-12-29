package com.dekanat.dekanat.server.controllers;

import com.dekanat.dekanat.server.Utils.Time;
import com.dekanat.dekanat.server.entity.Plan;
import com.dekanat.dekanat.server.entity.Speciality;
import com.dekanat.dekanat.server.requestbody.PlanBody;
import com.dekanat.dekanat.server.requestbody.SpecialityBody;
import com.dekanat.dekanat.server.service.DepartmentService;
import com.dekanat.dekanat.server.service.PlanService;
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
public class PlanController {

    @Autowired
    private PlanService planService;

    @Autowired
    private SpecialityService specialityService;

    @PostMapping("/addPlan")
    public void create(@RequestBody PlanBody planBody , HttpServletResponse response) throws ParseException {
        try{
            planService.createPlan(planBody.getId(), planBody.getHours(), planBody.getStartDate(), planBody.getEndDate(), planBody.getSpecialityNumber());
            response.setStatus(HttpServletResponse.SC_CREATED);
        }catch (Exception e) {
            response.setStatus(HttpServletResponse.SC_EXPECTATION_FAILED);
        }
    }

    @PostMapping("/deletePlan")
    public void delete(@RequestBody PlanBody planBody, HttpServletResponse response){
        Speciality speciality = specialityService.findById(planBody.getSpecialityNumber());
        Plan plan = new Plan(planBody.getId(), planBody.getHours(),Time.getLocalDate(planBody.getStartDate()),Time.getLocalDate(planBody.getEndDate()),speciality);
        planService.deletePlan(plan);
        response.setStatus(HttpServletResponse.SC_OK);
    }

    @PostMapping("/updatePlan")
    public void update(@RequestBody PlanBody planBody, HttpServletResponse response){
        planService.updatePlanName(planBody.getId(),planBody.getOldId(),
                planBody.getHours(),planBody.getEndDate(), planBody.getStartDate());
    }

    @PostMapping("/listPlan")
    public @ResponseBody
    List<Speciality> findAllByd(@RequestBody SpecialityBody specialityBody, HttpServletResponse response){
        response.setStatus(HttpServletResponse.SC_OK);
        return specialityService.findAllByDepartment(specialityBody.getName());
    }
}
