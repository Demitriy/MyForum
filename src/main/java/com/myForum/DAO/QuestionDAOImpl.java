package com.myForum.DAO;

import com.myForum.DatabaseEntity.Question;
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
public class QuestionDAOImpl implements QuestionDAO {
//t
    @Autowired
    @Qualifier(value = "dataSource")
    private DataSource dataSource;

    public void addQuestion(Question question) {
        if (dataSource != null) {
            Connection connection = null;
            try {
                connection = dataSource.getConnection();
                String sql = "INSERT INTO Questions (id, title, content) VALUES (?, ?, ?)";
                PreparedStatement preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setInt(1, question.getId());
                preparedStatement.setString(2, question.getTitle());
                preparedStatement.setString(3, question.getContent());
                preparedStatement.executeUpdate();
            } catch (SQLException e) {
                System.out.println("SQLException : QuestionDAOImpl : 37");
                e.printStackTrace();
            } finally {
                try {
                    if (connection != null) connection.close();
                } catch (SQLException e) {
                    System.out.println("SQLException : QuestionDAOImpl : 43");
                    e.printStackTrace();
                }
            }
        } else {
            System.out.println("dataSource is null : QuestionDAOImpl : 48");
        }
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
            } catch (SQLException e) {
                System.out.println("SQLException : QuestionDAOImpl : 67");
                e.printStackTrace();
            } finally {
                try {
                    if (connection != null) connection.close();
                } catch (SQLException e) {
                    System.out.println("SQLException : QuestionDAOImpl : 73");
                    e.printStackTrace();
                }
            }
            return result;
        } else {
            System.out.println("dataSource is null : QuestionDAOImpl : 49");
        }
        return null;
    }
}
