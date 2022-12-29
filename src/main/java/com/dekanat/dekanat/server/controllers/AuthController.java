package com.dekanat.dekanat.server.controllers;

import com.dekanat.dekanat.server.Utils.Security;
import com.dekanat.dekanat.server.entity.User;
import com.dekanat.dekanat.server.requestbody.LoginBody;
import com.dekanat.dekanat.server.service.UserService;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class AuthController {

    @Autowired
    UserService userService;

    @PostMapping("/login")
    public void login(@RequestBody LoginBody loginBody, HttpServletResponse response) {

        User user = userService.findAllByLogin(loginBody.getLogin()).get(0);
        String inHash = Security.hashPassword(user.getPswrd());
        String outHash = Security.hashPassword(loginBody.getPassword());
        if(inHash.equals(outHash)){
            response.setStatus(HttpServletResponse.SC_ACCEPTED);
        } else{
            response.setStatus(HttpServletResponse.SC_NOT_ACCEPTABLE);
        }
    }
}
