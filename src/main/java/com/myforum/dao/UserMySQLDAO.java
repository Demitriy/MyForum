package com.myforum.dao;

import com.myforum.database.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.*;

/**
 * Created by Dima on 19.03.2017.
 */
@Repository
public class UserMySQLDAO implements UserDAO {

    @Autowired
    private DataSource dataSource;

    public boolean addUser(User user) {
        if (dataSource != null) {
            Connection connection = null;
            try {
                connection = dataSource.getConnection();
                String sql = "INSERT INTO Users (login, password, name, email) VALUE (?, ?, ?, ?)";
                PreparedStatement preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setString(1, user.getLogin());
                preparedStatement.setString(2, user.getPassword());
                preparedStatement.setString(3, user.getName());
                preparedStatement.setString(4, user.getEmail());
                preparedStatement.executeUpdate();
                return true;
            } catch (Exception e) {
                System.out.println("SQLException : AnswerDAOImpl : 44");
                e.printStackTrace();
            } finally {
                try {
                    if (connection != null) connection.close();
                } catch (SQLException e) {
                    System.out.println("SQLException : AnswerDAOImpl : 50");
                    e.printStackTrace();
                }
            }
        } else {
            System.out.println("dataSource is null : AnswerDAOImpl : 55");
        }
        return false;
    }

    public User getUserByLogin(String login) {
        if (dataSource != null) {
            Connection connection = null;
            try {
                connection = dataSource.getConnection();
                String sql = "SELECT * from Users WHERE login=" + login + " OR email=" + login;
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery(sql);
                if (resultSet.next()) {
                    User user = new User();
                    user.setId(resultSet.getInt("id"));
                    user.setLogin(resultSet.getString("login")) ;
                    user.setPassword(resultSet.getString("password"));
                    user.setName(resultSet.getString("name"));
                    user.setEmail(resultSet.getString("email"));
                    return user;
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

    public User getUserByID(Integer id) {
        if (dataSource != null) {
            Connection connection = null;
            try {
                connection = dataSource.getConnection();
                String sql = "SELECT * from Users WHERE id=" + id;
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery(sql);
                if (resultSet.next()) {
                    User user = new User();
                    user.setId(resultSet.getInt("id"));
                    user.setLogin(resultSet.getString("login"));
                    user.setPassword(resultSet.getString("password"));
                    user.setName(resultSet.getString("name"));
                    user.setEmail(resultSet.getString("email"));
                    return user;
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
