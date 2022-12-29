package com.dekanat.dekanat.server.controllers;

import com.dekanat.dekanat.server.Utils.Time;
import com.dekanat.dekanat.server.entity.PersonalData;
import com.dekanat.dekanat.server.entity.Speciality;
import com.dekanat.dekanat.server.requestbody.PersonalDataBody;
import com.dekanat.dekanat.server.service.PersonalDataService;
import com.dekanat.dekanat.server.service.StudentCardService;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PersonalDataController {
    @Autowired
    private PersonalDataService personalDataService;

    @Autowired
    private StudentCardService studentCardService;

    @PostMapping("/addPersonalData")
    public void create(@RequestBody PersonalDataBody personalDataBody, HttpServletResponse response){
        personalDataService.createPersonalData(personalDataBody.getStudentNumber(), personalDataBody.getId(),
                personalDataBody.getFio(), personalDataBody.getCitizenship(), personalDataBody.getPipn(),
                personalDataBody.getBirthDate(), personalDataBody.getDocumentType());


    }

    @PostMapping("/deletePersonalData")
    public void delete(@RequestBody PersonalDataBody personalDataBody, HttpServletResponse response){

        PersonalData personalData = new PersonalData(personalDataBody.getId(),personalDataBody.getFio(),
                personalDataBody.getCitizenship(), personalDataBody.getPipn(),
                Time.getLocalDate(personalDataBody.getBirthDate()), personalDataBody.getDocumentType(),
                studentCardService.findById(personalDataBody.getStudentNumber()));

        personalDataService.deletePersonalData(personalData );
        response.setStatus(HttpServletResponse.SC_OK);
    }

    @PostMapping("/updatePersonalData")
    public void update(@RequestBody PersonalDataBody personalDataBody, HttpServletResponse response){
        personalDataService.updatePersonalData(personalDataBody.getStudentNumber(), personalDataBody.getId(),
                personalDataBody.getFio(), personalDataBody.getCitizenship(), personalDataBody.getPipn(),
                personalDataBody.getBirthDate(), personalDataBody.getDocumentType());

    }

    @PostMapping("/listPersonalData")
    public @ResponseBody
    PersonalData findByStudentCard(@RequestBody PersonalDataBody personalDataBody, HttpServletResponse response){
        response.setStatus(HttpServletResponse.SC_OK);
        return personalDataService.findAllByStudent(studentCardService.findById(personalDataBody.getStudentNumber())).get(0);
    }
}
