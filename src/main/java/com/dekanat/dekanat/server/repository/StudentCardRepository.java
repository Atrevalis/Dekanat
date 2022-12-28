package com.dekanat.dekanat.server.repository;

import com.dekanat.dekanat.server.entity.Speciality;
import com.dekanat.dekanat.server.entity.StudentCard;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentCardRepository extends JpaRepository<StudentCard, Integer> {
    List<StudentCard> findAll();

    List<StudentCard> findAllById(int numberSB);

    List<StudentCard> findAllBySpecialityNumber(Speciality speciality);

}