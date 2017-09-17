package com.myforum.converters;

import com.myforum.database.Admin;
import com.myforum.database.User;
import org.springframework.core.convert.converter.Converter;

/**
 * Created by Dima on 17.09.2017.
 */
public class AdminToUser implements Converter<Admin, User> {

    @Override
    public User convert(Admin admin) {
        return admin.getUser();
    }
}
