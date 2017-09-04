package com.myforum.service;

import com.myforum.database.User;

/**
 * Created by Dima on 19.03.2017.
 */
public interface UserService {

    boolean addUser(User user);

    boolean existLoginOrEmail(String value);

    User getAuthUser(String login, String password);
}
