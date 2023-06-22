import org.campusmolndal.todo.Todo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class userDatabase {

    private final Connection connection;

    public userDatabase() {
        String dbName = "todo_app_db";
        try {
            this.connection = DriverManager.getConnection("jdbc:sqlite:" + dbName + ".db");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void createUser(User user) {

        String sql = "INSERT INTO user(name,age) VALUES(?,?)";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, user.getName());
            preparedStatement.setInt(2, user.getAge());
            preparedStatement.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void updateUser(User user) {

        String sql = "UPDATE user SET name = ?, age = ?, WHERE (id = ?)";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(3, user.getId());
            preparedStatement.setString(1, user.getName());
            preparedStatement.setInt(2, user.getAge());
            preparedStatement.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }

    public List<User> getAllUsers() {
    }

    public User readUserByIndex(int index) {
    }

    public User readUserName(User user) {
    }
}
