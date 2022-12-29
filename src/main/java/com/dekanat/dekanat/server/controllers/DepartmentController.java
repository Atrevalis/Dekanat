package com.dekanat.dekanat.server.controllers;

import com.dekanat.dekanat.server.entity.Department;
import com.dekanat.dekanat.server.requestbody.DepartmentBody;
import com.dekanat.dekanat.server.service.DepartmentService;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class DepartmentController {
    @Autowired
    DepartmentService departmentService;

    @PostMapping("/addDepartment")
    public void createDepartment(@RequestBody DepartmentBody departmentBody , HttpServletResponse response){

        departmentService.createDepartment(departmentBody.getName());

        response.setStatus(HttpServletResponse.SC_CREATED);

    }

    @PostMapping("/deleteDepartment")
    public void deleteDepartment(@RequestBody DepartmentBody departmentBody, HttpServletResponse response){
        Department department = new Department(departmentBody.getId(),departmentBody.getName());
        departmentService.deleteDepartment(department);
        response.setStatus(HttpServletResponse.SC_OK);

    }

    @PostMapping("/updateDepartment")
    public void updateDepartment(@RequestBody DepartmentBody departmentBody, HttpServletResponse response){
        departmentService.updateDepartmentName(departmentBody.getName());
        response.setStatus(HttpServletResponse.SC_ACCEPTED);

    }

    @GetMapping("/listDepartment")
    public @ResponseBody
    List<Department> findAll(){
        return departmentService.findAll();
    }
}
