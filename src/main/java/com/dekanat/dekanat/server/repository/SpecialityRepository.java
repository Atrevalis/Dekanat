package com.dekanat.dekanat.server.repository;

import com.dekanat.dekanat.server.entity.Department;
import com.dekanat.dekanat.server.entity.Speciality;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface SpecialityRepository extends JpaRepository<Speciality, String> {
    List<Speciality> findAll();
    Optional<Speciality> findAllById(String id);

    List<Speciality> findAllByName(String name);

    List<Speciality> findAllByDepartment(Department department);

}