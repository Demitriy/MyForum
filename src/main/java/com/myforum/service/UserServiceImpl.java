package com.myforum.service;

import com.myforum.dao.UserDAO;
import com.myforum.database.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.ws.ServiceMode;

/**
 * Created by Dima on 19.03.2017.
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDAO userDAO;

    public boolean addUser(User user) {
        if (user.getName() == null) user.setName("");
        return userDAO.addUser(user);
    }

    public boolean loginExistOrEmail(String value) {
        return userDAO.getUserByLoginOrEmail(value) != null ? true : false;
    }
}
