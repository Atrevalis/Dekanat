package com.dekanat.dekanat.server.repository;

import com.dekanat.dekanat.server.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Integer> {
    List<User> findAll();
    List<User> findUserByFio(String fio);
}