import java.sql.SQLException;

public class TodoFacade {
    // hanterar objekten och databasen
    private TodoDatabase db;

    public TodoFacade() {

        try {
            this.db = new TodoDatabase();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void createTodo() {
        Todo todo = new Todo("Test text", 0);

        try {
            db.createTodo(todo);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Todo readTodo(int index) {
        Todo todo;
        try {
            todo = db.readTodoById(index);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return todo;
    }

    public void updateTodo(int index) {
        Todo todo = readTodo(index);

    }

    public void deleteTodo() {
    }
}
