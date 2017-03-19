package com.myforum.controller;

import com.myforum.database.User;
import com.myforum.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by Dima on 19.03.2017.
 */
@Controller
public class ControllerUser {

    @Autowired
    private UserService userService;

    @GetMapping("/registration")
    public String openRegistration() {
        return "registrationUser";
    }

    @PostMapping("/registration")
    public String addUser(@RequestParam("login") String login, @RequestParam("password") String password , @RequestParam("confirm") String confirm,
                          @RequestParam("email") String email, @RequestParam(value = "name", required = false) String name) {
        User user = new User();
        user.setLogin(login);
        user.setPassword(password);
        user.setEmail(email);
        user.setName(name);
        userService.addUser(user);
        return "redirect:/MyForum/";
    }

}
