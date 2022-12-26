package com.dekanat.dekanat.server.repository;

import com.dekanat.dekanat.server.entity.Speciality;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SpecialityRepository extends JpaRepository<Speciality, String> {
    List<Speciality> findAll();

}