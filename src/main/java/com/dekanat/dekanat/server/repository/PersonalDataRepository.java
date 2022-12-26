package com.dekanat.dekanat.server.repository;

import com.dekanat.dekanat.server.entity.PersonalData;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonalDataRepository extends JpaRepository<PersonalData, String> {
}