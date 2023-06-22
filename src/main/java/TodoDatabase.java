import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TodoDatabase implements TodoDatabaseInterface {

    private final Connection connection;

    public TodoDatabase() {
        String dbName = "todo_app_db";
        try {
            this.connection = DriverManager.getConnection("jdbc:sqlite:" + dbName + ".db");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    @Override
    public void createTodo(Todo todo) {

        String sql = "INSERT INTO todo(text,done,assignedTo) VALUES(?,?,?)";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, todo.getText());
            preparedStatement.setInt(2, todo.getDone());
            preparedStatement.setInt(3, todo.getAssignedTo());
            preparedStatement.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Todo readTodoById(int id) {

        String sql = "SELECT * FROM todo WHERE id LIKE ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, "" + id + "");
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

    @Override
    public Todo readTodoById(Todo todo) {

        String sql = "SELECT * FROM todo WHERE todo.text LIKE ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, "%" + todo.getText() + "%");
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

    @Override
    public void updateTodo(Todo todo) {

        String sql = "UPDATE todo SET text = ?, done = ?, assignedTo = ? WHERE id = " + todo.getId() + ";";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, todo.getText());
            preparedStatement.setInt(2, todo.getDone());
            preparedStatement.setInt(3, todo.getAssignedTo());
            preparedStatement.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
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

    @Override
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
