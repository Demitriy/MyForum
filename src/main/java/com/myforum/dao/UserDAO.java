package com.myforum.dao;

import com.myforum.database.User;

/**
 * Created by Dima on 19.03.2017.
 */
public interface UserDAO {

    boolean addUser(User user);

    User getUserByID(Integer id);

    User getUserByLoginOrEmail(String login);

}
