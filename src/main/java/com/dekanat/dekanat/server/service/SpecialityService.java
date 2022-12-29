package com.dekanat.dekanat.server.service;

import com.dekanat.dekanat.server.entity.Department;
import com.dekanat.dekanat.server.entity.Lesson;
import com.dekanat.dekanat.server.entity.Speciality;
import com.dekanat.dekanat.server.repository.DepartmentRepository;
import com.dekanat.dekanat.server.repository.LessonRepository;
import com.dekanat.dekanat.server.repository.SpecialityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class SpecialityService {

    @Autowired
    private SpecialityRepository specialityRepository;

    @Autowired
    private DepartmentRepository departmentRepository;

    public void createSpeciality(String name, String id, String departmentName) {
        Speciality speciality = new Speciality();
        speciality.setName(name);
        speciality.setId(id);
        speciality.setDepartment(departmentRepository.findAllByName(departmentName).get(0));
        specialityRepository.save(speciality);
    }

    public void deleteSpeciality(Speciality speciality) {
        specialityRepository.delete(speciality);
    }

    public void updateSpecialityName(String name, String oldName) throws NoSuchElementException {

        Speciality speciality = specialityRepository.findAllByName(oldName).get(0);
        speciality.setName(name);
        specialityRepository.save(speciality);
    }

    public List<Speciality> findAllByDepartment(String departmentName){
        return specialityRepository.findAllByDepartment(departmentRepository.findAllByName(departmentName).get(0));
    }

    public Speciality findByName(String name){
        return specialityRepository.findAllByName(name).get(0);
    }

    public Speciality findById(String name){
       return specialityRepository.findById(name).get();
    }
}
