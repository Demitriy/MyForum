package com.myForum.DAO;

import com.myForum.DatabaseEntity.Answer;
import com.myForum.DatabaseEntity.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
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
                System.out.println("SQLException : AnswerDAOImpl : 45");
                e.printStackTrace();
            } finally {
                try {
                    if (connection != null) connection.close();
                } catch (SQLException e) {
                    System.out.println("SQLException : AnswerDAOImpl : 51");
                    e.printStackTrace();
                }
            }
        } else {
            System.out.println("dataSource is null : AnswerDAOImpl : 56");
        }
    }

    public List<Answer> getAnswers(Question question) {
        return null;
    }
}
