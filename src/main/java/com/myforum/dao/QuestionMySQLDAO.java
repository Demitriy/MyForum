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
public class QuestionDAOImpl implements QuestionDAO {

    @Autowired
    @Qualifier(value = "dataSource")
    private DataSource dataSource;

    //обезательно ли сеттер для аннотаци Autowired

/*    public DataSource getDataSource() {
        return dataSource;
    }

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }*/

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
                System.out.println("SQLException : QuestionDAOImpl : 44");
                e.printStackTrace();
            } finally {
                try {
                    if (connection != null) connection.close();
                } catch (SQLException e) {
                    System.out.println("SQLException : QuestionDAOImpl : 50");
                    e.printStackTrace();
                }
            }
        } else {
            System.out.println("dataSource is null : QuestionDAOImpl : 55");
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
                return result;
            } catch (SQLException e) {
                System.out.println("SQLException : QuestionDAOImpl : 77");
                e.printStackTrace();
            } finally {
                try {
                    if (connection != null) connection.close();
                } catch (SQLException e) {
                    System.out.println("SQLException : QuestionDAOImpl : 83");
                    e.printStackTrace();
                }
            }
        } else {
            System.out.println("dataSource is null : QuestionDAOImpl : 88");
        }
        return null;
    }
}
