package com.myforum.service;

import com.myforum.database.User;

/**
 * Created by Dima on 05.09.2017.
 */
public interface AdminService {

    boolean isAdmin(Integer id);

    boolean isAdmin(User user);

}
