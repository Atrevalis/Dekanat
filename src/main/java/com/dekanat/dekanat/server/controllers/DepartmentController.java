package com.dekanat.dekanat.server.controllers;

import GUI.Utils.JsonHelper;
import com.dekanat.dekanat.server.entity.Department;
import com.dekanat.dekanat.server.requestbody.DepartmentBody;
import com.dekanat.dekanat.server.requestbody.LoginBody;
import com.dekanat.dekanat.server.service.DepartmentService;
import com.google.gson.Gson;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.UnsupportedEncodingException;
import java.util.List;


@RestController
public class DepartmentController {
    @Autowired
    DepartmentService departmentService;

    @PostMapping("/addDepartment")
    public void createDepartment(@RequestBody byte[] stream, HttpServletResponse response) throws UnsupportedEncodingException {

        String json = JsonHelper.replacer(new String(stream, "UTF-8"));

        DepartmentBody departmentBody = new Gson().fromJson(json, DepartmentBody.class);

        departmentService.createDepartment(departmentBody.getName());

        response.setStatus(HttpServletResponse.SC_CREATED);

    }

    @PostMapping("/deleteDepartment")
    public void deleteDepartment(@RequestBody byte[] stream, HttpServletResponse response) throws UnsupportedEncodingException {

        String json = JsonHelper.replacer(new String(stream, "UTF-8"));

        DepartmentBody departmentBody = new Gson().fromJson(json, DepartmentBody.class);

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
