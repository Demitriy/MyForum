package com.myforum.dao;

import com.myforum.database.Admin;
import com.myforum.database.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by Dima on 05.09.2017.
 */
@Repository
public class AdminMySQLDAO implements AdminDAO {

    @Autowired
    DataSource dataSource;
    @Autowired
    UserDAO userDAO;

    public Admin getAdminByID(Integer id) {
        if (dataSource != null) {
            Connection connection = null;
            try {
                connection = dataSource.getConnection();
                String sql = String.format("select * from admins where id = '%s'", id);
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery(sql);
                if (resultSet.next()) {
                    Admin admin = new Admin();
                    admin.setId(resultSet.getInt("id"));
                    admin.setUser(userDAO.getUserByID(resultSet.getInt("id_user")));
                    return admin;
                }
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                try {
                    if (connection != null) connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        } else {
            System.out.println("dataSource is null : UserMySQLDAO : 55");
        }
        return null;
    }

    public Admin getAdminByUser(User user) {
        if (dataSource != null) {
            Connection connection = null;
            try {
                connection = dataSource.getConnection();
                String sql = String.format("select * from admins where id_user = '%s'", user.getId());
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery(sql);
                if (resultSet.next()) {
                    Admin admin = new Admin();
                    admin.setId(resultSet.getInt("id"));
                    admin.setUser(user);
                    return admin;
                }
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                try {
                    if (connection != null) connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        } else {
            System.out.println("dataSource is null : UserMySQLDAO : 55");
        }
        return null;
    }
}
