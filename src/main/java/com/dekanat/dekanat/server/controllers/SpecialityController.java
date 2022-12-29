package com.dekanat.dekanat.server.controllers;

import com.dekanat.dekanat.server.entity.Department;
import com.dekanat.dekanat.server.entity.Speciality;;
import com.dekanat.dekanat.server.requestbody.SpecialityBody;
import com.dekanat.dekanat.server.service.DepartmentService;
import com.dekanat.dekanat.server.service.SpecialityService;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SpecialityController {
    @Autowired
    private SpecialityService specialityService;
    @Autowired
    private DepartmentService departmentService;

    @PostMapping("/addSpeciality")
    public void createSpeciality(@RequestBody SpecialityBody specialityBody , HttpServletResponse response){

        specialityService.createSpeciality(specialityBody.getName(), specialityBody.getId(), specialityBody.getDepartment());

        response.setStatus(HttpServletResponse.SC_CREATED);

    }

    @PostMapping("/deleteSpeciality")
    public void deleteSpeciality(@RequestBody SpecialityBody specialityBody, HttpServletResponse response){
        Speciality speciality = new Speciality(specialityBody.getId(), specialityBody.getName(), departmentService.findByName(specialityBody.getName()));
        specialityService.deleteSpeciality(speciality);
        response.setStatus(HttpServletResponse.SC_OK);
    }

    @PostMapping("/updateSpeciality")
    public void updateSpeciality(@RequestBody SpecialityBody specialityBody, HttpServletResponse response){
        specialityService.updateSpecialityName(specialityBody.getName(),specialityBody.getOldName());
    }

    @PostMapping("/listSpeciality")
    public @ResponseBody
    List<Speciality> findAllByDepartment(@RequestBody SpecialityBody specialityBody, HttpServletResponse response){
        response.setStatus(HttpServletResponse.SC_OK);
        return specialityService.findAllByDepartment(specialityBody.getName());
    }
}
