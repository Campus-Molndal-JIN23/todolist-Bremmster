package org.campusmolndal;

import org.campusmolndal.todo.Todo;
import org.campusmolndal.user.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DatabaseHandler {

    private static final DatabaseHandler instance = new DatabaseHandler();
    private final Connection connection;

    // private constructor to avoid client applications using the constructor
    private DatabaseHandler() {
        String dbName = "todo_app_db";
        try {
            this.connection = DriverManager.getConnection("jdbc:sqlite:" + dbName + ".db");
            createTables();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static DatabaseHandler getInstance() {
        return instance;
    }

    private void createTables() {

        String users = "CREATE TABLE IF NOT EXISTS user ( id INTEGER UNIQUE, name TEXT, age INTEGER, PRIMARY KEY( id AUTOINCREMENT) )";

        String todo = "CREATE TABLE IF NOT EXISTS todo ( id INTEGER NOT NULL UNIQUE, text TEXT, done INTEGER NOT NULL, assignedTo INTEGER, FOREIGN KEY(assignedTo) REFERENCES user(id), PRIMARY KEY(id AUTOINCREMENT) )";

        try {
            PreparedStatement createUserTable = connection.prepareStatement(users);
            createUserTable.execute();
            PreparedStatement createTodoTable = connection.prepareStatement(todo);
            createTodoTable.execute();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public void createTodo(Todo todo, User currentUser) {

        String sql = "INSERT INTO todo(text,done,assignedTo) VALUES(?,?,?)";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, todo.getText());
            preparedStatement.setInt(2, todo.getDone());
            preparedStatement.setInt(3, currentUser.getId());
            preparedStatement.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Todo readTodoById(int id) {

        String sql = "SELECT * FROM todo WHERE id LIKE ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, String.valueOf(id));
            ResultSet resultSet = preparedStatement.executeQuery();

            return new Todo(resultSet.getInt("id"),
                    resultSet.getString("text"),
                    resultSet.getInt("done"),
                    resultSet.getInt("assignedTo")
            );
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Todo readTodoById(Todo todo) {

        String sql = "SELECT * FROM todo WHERE text LIKE ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, todo.getText());
            ResultSet resultSet = preparedStatement.executeQuery();

            return new Todo(resultSet.getInt("id"),
                    resultSet.getString("text"),
                    resultSet.getInt("done"),
                    resultSet.getInt("assignedTo")
            );
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean updateTodo(Todo todo) {

        String sql = "UPDATE todo SET text = ?, done = ?, assignedTo = ? WHERE id = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, todo.getText());
            preparedStatement.setInt(2, todo.getDone());
            preparedStatement.setInt(3, todo.getAssignedTo());
            preparedStatement.setInt(4, todo.getId());
            preparedStatement.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return true;
    }


    public void deleteTodo(Todo todo) {

        String sql = "DELETE FROM todo WHERE id = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, todo.getId());
            preparedStatement.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    public List<Todo> getAllTodos() {

        String sql = "SELECT * FROM todo WHERE id LIKE ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, "%");

            return getTodos(preparedStatement);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Todo> getAllUserTodos(User user) {

        String sql = "SELECT * FROM todo WHERE assignedTo LIKE ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, user.getId());

            return getTodos(preparedStatement);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private List<Todo> getTodos(PreparedStatement preparedStatement) throws SQLException {
        // Used by all the sql query that returns lists If nothing is found return null
        List<Todo> todos = new ArrayList<>();
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            todos.add(new Todo(resultSet.getInt("id"),
                    resultSet.getString("text"),
                    resultSet.getInt("done"),
                    resultSet.getInt("assignedTo")
            ));
        }
        if (todos.isEmpty()) {
            return null;
        }
        return todos;
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

    private List<User> getUsers(PreparedStatement preparedStatement) throws SQLException {
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
        String sql = "SELECT * FROM user WHERE id = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, String.valueOf(id));
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
