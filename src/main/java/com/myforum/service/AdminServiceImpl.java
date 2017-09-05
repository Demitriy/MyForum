package com.myforum.service;

import com.myforum.dao.AdminDAO;
import com.myforum.database.User;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by Dima on 05.09.2017.
 */
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminDAO adminDAO;

    public boolean isAdmin(Integer id) {
        return adminDAO.getAdminByID(id) != null ? true : false;
    }

    public boolean isAdmin(User user) {
        return adminDAO.getAdminByUser(user) != null ? true : false;
    }

}
