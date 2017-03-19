package com.myforum.dao;

import com.myforum.database.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;


import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by dsvetyshov on 06.03.2017.
 */
@Repository
public class QuestionMySQLDAO implements QuestionDAO {

    @Autowired
    private DataSource dataSource;

    public boolean addQuestion(Question question) {
        if (dataSource != null) {
            Connection connection = null;
            try {
                connection = dataSource.getConnection();
                String sql = "INSERT INTO Questions (title, content) VALUE (?, ?)";
                PreparedStatement preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setString(1, question.getTitle());
                preparedStatement.setString(2, question.getContent());
                preparedStatement.executeUpdate();
                return true;
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
            System.out.println("dataSource is null : QuestionDAOImpl : 55");
        }
        return false;
    }

    public List<Question> getAllQuestions() {
        if (dataSource != null) {
            Connection connection = null;
            List<Question> result = new ArrayList<Question>();
            try {
                connection = dataSource.getConnection();
                String sql = "SELECT * FROM Questions";
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery(sql);
                while (resultSet.next()) {
                    Question question = new Question();
                    question.setId(resultSet.getInt("id"));
                    question.setTitle(resultSet.getString("title"));
                    question.setContent(resultSet.getString("content"));
                    result.add(question);
                }
                return result;
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
            System.out.println("dataSource is null : QuestionDAOImpl : 88");
        }
        return null;
    }

    public Question getQuestionByID(Integer id) {
        if (dataSource != null) {
            Connection connection = null;
            try {
                connection = dataSource.getConnection();
                String sql = "SELECT * FROM Questions WHERE id = ?";
                PreparedStatement statement = connection.prepareStatement(sql);
                statement.setInt(1, id);
                ResultSet resultSet = statement.executeQuery();
                if (resultSet.next()) {
                    Question question = new Question();
                    question.setId(resultSet.getInt("id"));
                    question.setTitle(resultSet.getString("title"));
                    question.setContent(resultSet.getString("content"));
                    return question;
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
            System.out.println("dataSource is null : QuestionDAOImpl : 88");
        }
        return null;
    }

    public List<Question> getQuestionsByTitle(String title) {
        if (dataSource != null) {
            Connection connection = null;
            List<Question> result = new ArrayList<Question>();
            try {
                connection = dataSource.getConnection();
                String sql = "SELECT * FROM Questions WHERE title LIKE '%"+title+"%'";
                Statement preparedStatement = connection.createStatement();
                ResultSet resultSet = preparedStatement.executeQuery(sql);
                while (resultSet.next()) {
                    Question question = new Question();
                    question.setId(resultSet.getInt("id"));
                    question.setTitle(resultSet.getString("title"));
                    question.setContent(resultSet.getString("content"));
                    result.add(question);
                }
                return result;
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
            System.out.println("dataSource is null : QuestionDAOImpl : 88");
        }
        return null;
    }
}
