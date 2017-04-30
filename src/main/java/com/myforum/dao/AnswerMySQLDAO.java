package com.myforum.dao;

import com.myforum.database.Answer;
import com.myforum.database.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Dima on 06.03.2017.
 */

@Repository
public class AnswerMySQLDAO implements AnswerDAO {

    @Autowired
    private DataSource dataSource;

    public boolean addAnswer(Answer answer) {
        if (dataSource != null) {
            Connection connection = null;
            try {
                connection = dataSource.getConnection();
                String sql = "INSERT INTO Answers (id_question, comment) VALUE (?, ?)";
                PreparedStatement preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setInt(1, answer.getQuestion().getId());
                preparedStatement.setString(2, answer.getComment());
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

    public List<Answer> getAnswersByQuestion(Question question) {
        if (dataSource != null) {
            Connection connection = null;
            List<Answer> result = new ArrayList<Answer>();
            try {
                connection = dataSource.getConnection();
                //String sql = "SELECT * FROM Questions AS qst JOIN Answers AS ans ON qst.id = ans.id_question + WHERE qst.id = ?" ;
                String sql = "SELECT * FROM Answers WHERE id_question = ?";
                PreparedStatement preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setInt(1, question.getId());
                ResultSet resultSet = preparedStatement.executeQuery();
                while (resultSet.next()) {
                    Answer answer = new Answer();
                    answer.setId(resultSet.getInt("id"));
                    answer.setComment(resultSet.getString("comment"));
                    answer.setQuestion(question);
                    result.add(answer);
                }
                return result;
            } catch (SQLException e) {
                System.out.println("SQLException : AnswerDAOImpl : 77");
                e.printStackTrace();
            } finally {
                try {
                    if (connection != null) connection.close();
                } catch (SQLException e) {
                    System.out.println("SQLException : AnswerDAOImpl : 83");
                    e.printStackTrace();
                }
            }
        } else {
            System.out.println("dataSource is null : AnswerDAOImpl : 88");
        }
        return null;
    }
    
}
