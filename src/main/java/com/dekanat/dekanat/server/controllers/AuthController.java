package com.dekanat.dekanat.server.controllers;

import GUI.Utils.JsonHelper;
import com.dekanat.dekanat.server.entity.Department;
import com.google.gson.Gson;
import com.dekanat.dekanat.server.Utils.Security;
import com.dekanat.dekanat.server.entity.User;
import com.dekanat.dekanat.server.requestbody.LoginBody;
import com.dekanat.dekanat.server.requestbody.UserBody;
import com.dekanat.dekanat.server.service.UserService;
import com.google.gson.JsonArray;
import com.google.gson.JsonParser;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.util.LinkedList;
import java.util.List;

@RestController
public class AuthController {

    final
    UserService userService;

    public AuthController(UserService userService) {
        this.userService = userService;
    }

//     @GetMapping ("/test")
//     public void test(HttpServletResponse response) throws UnsupportedEncodingException {
//
//         List<User> all = userService.findAllUser();
//         response.setStatus(200);
//         String userBodyJson = new String(stream, "UTF-8");
//         userBodyJson = JsonHelper.replacer(userBodyJson);
//
//         UserBody userBody = new Gson().fromJson(userBodyJson, UserBody.class);
//         if (userBody.getLogin()=="admin"){
//             response.setStatus(203);
//         }
//         else
//         response.setStatus(400);
   //  }
        @PostMapping("/login")
    public @ResponseBody
        int login(@RequestBody byte[] stream, HttpServletResponse response) throws UnsupportedEncodingException {
            String json = JsonHelper.replacer(new String(stream, "UTF-8"));

            LoginBody loginBody = new Gson().fromJson(json, LoginBody.class);
            String outHash = Security.hashPassword(loginBody.getPassword());
            List<User> users =  userService.findAllByLogin(loginBody.getLogin());
            User user = users.get(0);
            String inHash = user.getPswrd();
        if(inHash.equals(outHash)){
            response.setStatus(HttpServletResponse.SC_ACCEPTED);
        } else{
            response.setStatus(HttpServletResponse.SC_NOT_ACCEPTABLE);
        }
        return user.getRole();
    }
}
