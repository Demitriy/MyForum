package com.myforum.controller;

import com.myforum.database.User;
import com.myforum.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by Dima on 19.03.2017.
 */
@Controller
public class ControllerUser {

    @Autowired
    private UserService userService;

    @GetMapping("/registration")
    public ModelAndView openRegistration() {
        return new ModelAndView("registrationUser");
    }

    @PostMapping("/registration")
    public ModelAndView addUser(@RequestParam("login") String login, @RequestParam("password") String password , @RequestParam("confirm") String confirm,
                                @RequestParam("email") String email, @RequestParam(value = "name", required = false) String name) {
        if (userService.loginExistOrEmail(login)) {
            return openRegistration();
        }
        else if (!password.equals(confirm)) return openRegistration();
        else if (userService.loginExistOrEmail(email)) return openRegistration();
        else {
            User user = new User();
            user.setLogin(login);
            user.setPassword(password);
            user.setEmail(email);
            user.setName(name);
            return new ModelAndView("greetingCard");
        }
    }

}
