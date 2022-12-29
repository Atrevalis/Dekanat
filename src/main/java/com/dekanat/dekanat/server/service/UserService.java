package com.dekanat.dekanat.server.service;

import com.dekanat.dekanat.server.entity.Lesson;
import com.dekanat.dekanat.server.entity.User;
import com.dekanat.dekanat.server.repository.LessonRepository;
import com.dekanat.dekanat.server.repository.SemesterRepository;
import com.dekanat.dekanat.server.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;


    public void createUser(String login, String pswrd, int role, String fio) {
        User user = new User();
        user.setFio(fio);
        user.setLogin(login);
        user.setRole(role);
        user.setPswrd(pswrd);

        userRepository.save(user);
    }

    public void deleteUser(User user) {
        userRepository.delete(user);
    }

    public void updateUser(String login, String fio, String pswrd, int role) throws NoSuchElementException {

        User user = userRepository.findAllByLogin(login).get(0);
        user.setFio(fio);
        user.setLogin(login);
        user.setRole(role);
        user.setPswrd(pswrd);

        userRepository.save(user);
    }

    public List<User> findAllUser(){
        return userRepository.findAll();
    }

    public List<User> findAllByLogin(String login){
        return userRepository.findAllByLogin(login);
    }
}
