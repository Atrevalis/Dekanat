package com.dekanat.dekanat.server.repository;

import com.dekanat.dekanat.server.entity.Plan;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlanRepository extends JpaRepository<Plan, Integer> {
}