import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TodoRepository {
    private final String dbName;
    private Connection connection;

    public TodoRepository() throws SQLException {
        this.dbName = "todo_app_db";
        connection = DriverManager.getConnection("jdbc:sqlite:" + dbName + ".db");
    }

    public Todo getTodoById(int id) throws SQLException {

        String sql = "SELECT * FROM " + this.dbName + " WHERE id LIKE ?";

        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, "%" + id + "%");
        ResultSet resultSet = preparedStatement.executeQuery();

        return new Todo(resultSet.getInt("id"),
                resultSet.getString("text"),
                resultSet.getInt("done"),
                resultSet.getInt("assignedTo")
        );
    }

    public List<Todo> getAllTodos() throws SQLException {

        String sql = "SELECT * FROM " + this.dbName + " WHERE id LIKE ?";

        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, "%" + "*" + "%");

        return getTodos(preparedStatement);
    }

    private List<Todo> getTodos(PreparedStatement preparedStatement) throws SQLException { // KK
        // Used by all the sql query, adds result to list. If nothing is found return null
        List<Todo> todos = new ArrayList<>();
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            todos.add(new Todo(resultSet.getInt("id"),
                    resultSet.getString("text"),
                    resultSet.getInt("done"),
                    resultSet.getInt("asignedTo")
            ));
        }
        if (todos.isEmpty()) {
            return null;
        }
        return todos;
    }

}
