package com.dekanat.dekanat.server.service;

import com.dekanat.dekanat.server.entity.Speciality;
import com.dekanat.dekanat.server.entity.StudentCard;
import com.dekanat.dekanat.server.repository.DepartmentRepository;
import com.dekanat.dekanat.server.repository.SpecialityRepository;
import com.dekanat.dekanat.server.repository.StudentCardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class StudentCardService {
    @Autowired
    private StudentCardRepository studentCardRepository;

    @Autowired
    private SpecialityRepository specialityRepository;

    public void createStudentCard(int form, int finance, String startDate,String endDate, int groupNumber, String name, int numberSB) {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate localDate = LocalDate.parse(startDate, formatter);

        StudentCard studentCard = new StudentCard();
        studentCard.setId(numberSB);
        studentCard.setForm(form);
        studentCard.setFinance(finance);
        studentCard.setStartDate(localDate);
        localDate = LocalDate.parse(endDate, formatter);
        studentCard.setEndDate(localDate);
        studentCard.setGroupNumber(groupNumber);
        studentCard.setSpecialityNumber(specialityRepository.findAllByName(name).get(0));


        studentCardRepository.save(studentCard);
    }

    public void deleteStudentCard(StudentCard studentCard) {
        studentCardRepository.delete(studentCard);
    }

    public void updateStudentCard(int form, int finance, String startDate,String endDate, int groupNumber, int numberSB) throws NoSuchElementException {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate localDate = LocalDate.parse(startDate, formatter);

        StudentCard studentCard = studentCardRepository.findAllById(numberSB).get(0);

        studentCard.setForm(form);
        studentCard.setFinance(finance);
        studentCard.setStartDate(localDate);
        localDate = LocalDate.parse(endDate, formatter);
        studentCard.setEndDate(localDate);
        studentCard.setGroupNumber(groupNumber);

        studentCardRepository.save(studentCard);
    }

    public List<StudentCard> findAll(){
        return studentCardRepository.findAll();
    }
    public List<StudentCard> findAllBySpeciality(String specialityName){
        return studentCardRepository.findAllBySpecialityNumber(specialityRepository.findAllByName(specialityName).get(0));
    }
}
