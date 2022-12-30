package com.dekanat.dekanat.server.controllers;

import GUI.Utils.JsonHelper;
import com.dekanat.dekanat.server.Utils.Time;
import com.dekanat.dekanat.server.entity.Plan;
import com.dekanat.dekanat.server.entity.Speciality;
import com.dekanat.dekanat.server.entity.User;
import com.dekanat.dekanat.server.requestbody.LoginBody;
import com.dekanat.dekanat.server.requestbody.PlanBody;
import com.dekanat.dekanat.server.requestbody.SpecialityBody;
import com.dekanat.dekanat.server.requestbody.UserBody;
import com.dekanat.dekanat.server.service.PlanService;
import com.dekanat.dekanat.server.service.SpecialityService;
import com.dekanat.dekanat.server.service.UserService;
import com.google.gson.Gson;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.UnsupportedEncodingException;
import java.text.ParseException;
import java.util.List;
@RestController
public class UserController {

    @Autowired
    private UserService userService;


    @PostMapping("/addUser")
    public void create(@RequestBody byte[] stream, HttpServletResponse response) throws UnsupportedEncodingException {
        String json = JsonHelper.replacer(new String(stream, "UTF-8"));

        UserBody userBody = new Gson().fromJson(json, UserBody.class);
        userService.createUser(userBody.getLogin(), userBody.getPswrd(), userBody.getRole(), userBody.getFio());
        response.setStatus(HttpServletResponse.SC_ACCEPTED);
    }

    @PostMapping("/deleteUser")
    public void delete(@RequestBody UserBody userBody, HttpServletResponse response){
        User user = new User(userBody.getId(), userBody.getLogin(), userBody.getPswrd(),
                userBody.getRole(), userBody.getFio());
        userService.deleteUser(user);
        response.setStatus(HttpServletResponse.SC_OK);
    }

    @PostMapping("/updateUser")
    public void update(@RequestBody UserBody userBody, HttpServletResponse response){
        userService.updateUser(userBody.getLogin(), userBody.getFio(), userBody.getPswrd(), userBody.getRole());
    }

    @GetMapping("/listUser")
    public @ResponseBody
    List<User> findAll(HttpServletResponse response){
        response.setStatus(HttpServletResponse.SC_OK);
        return userService.findAllUser();
    }
}
