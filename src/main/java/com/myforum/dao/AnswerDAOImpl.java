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
public class AnswerDAOImpl implements AnswerDAO {

    @Autowired
    @Qualifier(value = "dataSource")
    private DataSource dataSource;

    public DataSource getDataSource() {
        return dataSource;
    }

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public void addAnswer(Answer answer) {
        if (dataSource != null) {
            Connection connection = null;
            try {
                connection = dataSource.getConnection();
                String sql = "INSERT INTO Answers (id, id_question, content) VALUES (?, ?, ?)";
                PreparedStatement preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setInt(1, answer.getId());
                preparedStatement.setInt(2, answer.getQuestion().getId());
                preparedStatement.setString(3, answer.getComment());
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

    public List<Answer> getAnswers(Question question) {
        if (dataSource != null) {
            Connection connection = null;
            List<Answer> result = new ArrayList<Answer>();
            try {
                connection = dataSource.getConnection();
                String sql = "SELECT * FROM Questions AS qst JOIN Answers AS ans ON qst.id = ans.id_question";
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery(sql);
                while (resultSet.next()) {
                    Answer answer = new Answer();
                    answer.setId(resultSet.getInt("ans.id"));
                    answer.setComment(resultSet.getString("ans.comment"));
                    answer.setQuestion(question);
                    result.add(answer);
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
