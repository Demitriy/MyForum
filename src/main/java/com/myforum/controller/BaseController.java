package com.myforum.controller;

import com.myforum.constants.Role;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.WebRequestDataBinder;
import org.springframework.web.context.request.WebRequest;

/**
 * Created by Dima on 20.08.2017.
 */
@SessionAttributes("role")
public class BaseController {

    @ModelAttribute("role")
    public Role getRole() {
        return Role.GUEST;
    }
}
