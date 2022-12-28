package com.dekanat.dekanat.server.repository;

import com.dekanat.dekanat.server.entity.Plan;
import com.dekanat.dekanat.server.entity.Speciality;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PlanRepository extends JpaRepository<Plan, Integer> {
    List<Plan> findAll();

    List<Plan> findAllById(int id);

    List<Plan> findAllBySpecialityNumber(Speciality speciality);
}