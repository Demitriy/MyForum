package com.myforum.controller;

import com.myforum.constants.Role;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;

/**
 * Created by Dima on 20.08.2017.
 */
@SessionAttributes("role")
public class BaseController {

    @ModelAttribute("role")
    public Role getRole() {
        System.out.println("getRole");
        return Role.GUEST;
    }
}
