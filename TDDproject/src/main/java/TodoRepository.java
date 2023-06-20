import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TodoRepository {
    private final Connection connection;

    public TodoRepository() throws SQLException {
        String dbName = "todo_app_db";
        this.connection = DriverManager.getConnection("jdbc:sqlite:" + dbName + ".db");
    }


    public void createTodo(Todo todo) throws SQLException {

        String sql = "INSERT INTO todo(text,done,assignedTo) VALUES(?,?,?)";

        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, todo.getText());
        preparedStatement.setInt(2, todo.getDone());
        preparedStatement.setInt(3, todo.getAssignedTo());
        preparedStatement.execute();
    }

    public Todo readTodoById(int id) throws SQLException {

        String sql = "SELECT * FROM todo WHERE id LIKE ?";

        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, "%" + id + "%");
        ResultSet resultSet = preparedStatement.executeQuery();

        return new Todo(resultSet.getInt("id"),
                resultSet.getString("text"),
                resultSet.getInt("done"),
                resultSet.getInt("assignedTo")
        );
    }

    public void updateTodo(Todo todo) throws SQLException {

        String sql = "UPDATE todo SET text = ?, done = ?, assignedTo = ? WHERE id = " + todo.getId() + ";";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, todo.getText());
        preparedStatement.setInt(2, todo.getDone());
        preparedStatement.setInt(3, todo.getAssignedTo());
        preparedStatement.execute();
    }

    public void deleteTodo(Todo todo) throws SQLException {

        String sql = "DELETE FROM todo WHERE id = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, todo.getId());
        preparedStatement.execute();

    }

    public List<Todo> getAllTodos() throws SQLException {

        String sql = "SELECT * FROM todo WHERE id LIKE ?";

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
                    resultSet.getInt("assignedTo")
            ));
        }
        if (todos.isEmpty()) {
            return null;
        }
        return todos;
    }
}
