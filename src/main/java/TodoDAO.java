import java.sql.SQLException;
import java.util.List;

public interface TodoDAO {

    void createTodo(Todo todo) throws SQLException;

    Todo readTodoById(int id) throws SQLException;

    void updateTodo(Todo todo) throws SQLException;

    void deleteTodo(Todo todo) throws SQLException;

    Todo readTodoById(Todo todo) throws SQLException;

    List<Todo> getAllTodos() throws SQLException;
}
