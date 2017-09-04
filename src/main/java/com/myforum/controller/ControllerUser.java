package com.myforum.controller;

import com.myforum.constants.ErrorMsg;
import com.myforum.constants.Role;
import com.myforum.database.User;
import com.myforum.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.view.RedirectView;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Dima on 19.03.2017.
 */
@Controller
class ControllerUser extends BaseController {

    @Autowired
    private UserService userService;

    @GetMapping("/**/registration")
    public ModelAndView openRegistration() {
        return new ModelAndView("registrationUser");
    }

    @PostMapping("/**/registration")
    public ModelAndView addUser(@RequestParam("login") String login, @RequestParam("password") String password , @RequestParam("confirm") String confirm,
                                @RequestParam("email") String email, @RequestParam(value = "name", required = false) String name) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("val_login", login);
        map.put("val_email", email);
        map.put("val_name", name);
        if (!password.trim().equals(confirm.trim())) {
            map.put("flag", 2);
            map.put("error", ErrorMsg.PASSWORD);
            return new ModelAndView("registrationUser", map);
        }
        else if (userService.existLoginOrEmail(login)) {
            map.put("flag", 1);
            map.put("error", ErrorMsg.lOGIN);
            return new ModelAndView("registrationUser", map);
        }
        else if (userService.existLoginOrEmail(email)) {
            map.put("flag", 3);
            map.put("error", ErrorMsg.EMAIL);
            return new ModelAndView("registrationUser", map);
        } else if (!email.matches("[a-zA-Z0-9.]+@[a-zA-Z]+\\.[a-zA-Z]+")) {
            map.put("flag", 3);
            map.put("error", ErrorMsg.INVALID_EMAIL);
            return new ModelAndView("registrationUser", map);
        }
        else {
            User user = new User();
            user.setLogin(login);
            user.setPassword(password);
            user.setEmail(email);
            user.setName(name);
            userService.addUser(user);
            return new ModelAndView("greetingCard", "user", user);
        }
    }

    @GetMapping("/**/login")
    public String openLogin() {
        return "login";
    }

    @PostMapping("/**/login")
    public ModelAndView signIn(@RequestParam("login") String login, @RequestParam("password") String password, ModelMap modelMap) {
        User user = userService.getAuthUser(login, password);
        if (user != null) {
            modelMap.addAttribute("authUser", user);
            modelMap.addAttribute("role", Role.USER);
            RedirectView redirectView = new RedirectView("/MyForum/");
            redirectView.setExposeModelAttributes(false);
            return new ModelAndView(redirectView);
        }
        modelMap.addAttribute("flag", true);
        modelMap.addAttribute("error", ErrorMsg.INVALID_SIGN_IN);
        return new ModelAndView("login", modelMap);
    }

    @GetMapping("/**/logout")
    public View logOut(SessionStatus httpStatus) {
        httpStatus.setComplete();
        RedirectView redirectView = new RedirectView("/MyForum/");
        redirectView.setExposeModelAttributes(false);
        return redirectView;
    }
}
