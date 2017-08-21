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
        user.setLogin(user.getLogin().toUpperCase().trim());
        user.setEmail(user.getEmail().toUpperCase().trim());
        user.setPassword(user.getPassword().trim());
        user.setName(user.getName() != null ? user.getName().trim() : null);
        return userDAO.addUser(user);
    }

    public boolean existLoginOrEmail(String value) {
        return userDAO.getUserByLoginOrEmail(value.toUpperCase().trim()) != null ? true : false;
    }

    public User getUser(String login, String password) {
        User user = userDAO.getUserByLoginOrEmail(login);
        if (user != null) {
            if (user.getPassword().equals(password)) {
                return user;
            }
        }
        return null;
    }
}
