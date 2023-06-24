package org.campusmolndal.user;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDatabase {

    private final Connection connection;

    public UserDatabase() {
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

        String sql = "UPDATE user SET name = ?, age = ? WHERE id = ?";
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

        String sql = "SELECT * FROM user WHERE id LIKE ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, "%");

            return getUsers(preparedStatement);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    private List<User> getUsers(PreparedStatement preparedStatement) throws SQLException { // KK
        // Used by all the sql query, adds result to list. If nothing is found return null
        List<User> users = new ArrayList<>();
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            users.add(new User(resultSet.getInt("id"),
                    resultSet.getString("name"),
                    resultSet.getInt("age")
            ));
        }
        if (users.isEmpty()) {
            return null;
        }
        return users;
    }

    public User readUserByIndex(User user) {
        String sql = "SELECT * FROM user WHERE ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, user.getId());
            ResultSet resultSet = preparedStatement.executeQuery();

            return new User(resultSet.getInt("id"),
                    resultSet.getString("name"),
                    resultSet.getInt("age")
            );
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public User readUserByIndex(int id) {
        String sql = "SELECT * FROM user WHERE ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();

            return new User(resultSet.getInt("id"),
                    resultSet.getString("name"),
                    resultSet.getInt("age")
            );
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public User readUserName(User user) {
        String sql = "SELECT * FROM user WHERE ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, user.getName());
            ResultSet resultSet = preparedStatement.executeQuery();

            return new User(resultSet.getInt("id"),
                    resultSet.getString("name"),
                    resultSet.getInt("age")
            );
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
