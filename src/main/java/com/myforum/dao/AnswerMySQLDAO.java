package com.myforum.dao;

import com.myforum.database.Answer;
import com.myforum.database.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

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
    @Qualifier(value = "dataSource")
    private DataSource dataSource;

    //обезательно ли сеттер для аннотаци Autowired

/*    public DataSource getDataSource() {
        return dataSource;
    }

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }*/

    public void addAnswer(Answer answer) {
        if (dataSource != null) {
            Connection connection = null;
            try {
                connection = dataSource.getConnection();
                String sql = "INSERT INTO Answers (id_question, content) VALUE (?, ?)";
                PreparedStatement preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setInt(1, answer.getQuestion().getId());
                preparedStatement.setString(2, answer.getComment());
                preparedStatement.executeUpdate();
            } catch (SQLException e) {
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
                ResultSet resultSet = preparedStatement.executeQuery(sql);
                while (resultSet.next()) {
                    Answer answer = new Answer();
                    answer.setId(resultSet.getInt("ans.id"));
                    answer.setComment(resultSet.getString("ans.comment"));
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
