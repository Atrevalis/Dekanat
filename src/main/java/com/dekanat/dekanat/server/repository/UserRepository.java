package com.dekanat.dekanat.server.repository;

import com.dekanat.dekanat.server.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {
    List<User> findAll();
    List<User> findUserByFio(String fio);
    Optional<User> findUserById(int id);

    List<User> findAllByLogin(String login);
}