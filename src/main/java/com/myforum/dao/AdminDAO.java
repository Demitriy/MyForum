package com.myforum.dao;

import com.myforum.database.Admin;
import com.myforum.database.User;

/**
 * Created by Dima on 05.09.2017.
 */
public interface AdminDAO {

    Admin getAdminByID(Integer id);

    Admin getAdminByUser(User user);
}
