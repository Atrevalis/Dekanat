package com.dekanat.dekanat.server.repository;

import com.dekanat.dekanat.server.entity.PersonalData;
import com.dekanat.dekanat.server.entity.StudentCard;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PersonalDataRepository extends JpaRepository<PersonalData, String> {
    List<PersonalData> findAll();

    List<PersonalData> findAllByStudentNumber(StudentCard studentCard);
}