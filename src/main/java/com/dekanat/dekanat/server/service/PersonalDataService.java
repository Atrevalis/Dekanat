package com.dekanat.dekanat.server.service;

import com.dekanat.dekanat.server.entity.PersonalData;
import com.dekanat.dekanat.server.entity.StudentCard;
import com.dekanat.dekanat.server.repository.PersonalDataRepository;
import com.dekanat.dekanat.server.repository.StudentCardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
public class PersonalDataService {

    @Autowired
    PersonalDataRepository personalDataRepository;
    @Autowired
    StudentCardRepository studentCardRepository;

    public void createPersonalData(int numberSB, String serialNumber, String fio,String citizenship,
                                   String pipn, String bd, int docType){
        PersonalData personalData = new PersonalData();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate localDate = LocalDate.parse(bd, formatter);

        personalData.setId(serialNumber);
        personalData.setFio(fio);
        personalData.setCitizenship(citizenship);
        personalData.setPipn(pipn);
        personalData.setBirthDate(localDate);
        personalData.setDocumentType(docType);
        personalData.setStudentNumber(studentCardRepository.findAllById(numberSB).get(0));

        personalDataRepository.save(personalData);
    }

    public void deletePersonalData(PersonalData personalData) {
        personalDataRepository.delete(personalData);
    }

    public void updatePersonalData(int numberSB, String serialNumber, String fio,String citizenship,
                                   String pipn, String bd, int docType){
        PersonalData personalData = personalDataRepository.findAllByStudentNumber
                (studentCardRepository.findAllById(numberSB).get(0)).get(0);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate localDate = LocalDate.parse(bd, formatter);

        personalData.setId(serialNumber);
        personalData.setFio(fio);
        personalData.setCitizenship(citizenship);
        personalData.setPipn(pipn);
        personalData.setBirthDate(localDate);
        personalData.setDocumentType(docType);
        personalData.setStudentNumber(studentCardRepository.findAllById(numberSB).get(0));

        personalDataRepository.save(personalData);
    }

    public List<PersonalData> findAllByStudent(StudentCard studentCard){
        return personalDataRepository.findAllByStudentNumber(studentCard);
    }
}
