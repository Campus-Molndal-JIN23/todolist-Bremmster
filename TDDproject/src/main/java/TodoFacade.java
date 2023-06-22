import java.sql.SQLException;
import java.util.List;

public class TodoFacade {
    // hanterar objekten och databasen
    private TodoDatabase db;

    public TodoFacade() {

        this.db = new TodoDatabase();
    }

    public TodoFacade(TodoDatabase db) { // this constructor exists to enable testing
        this.db = db;
    }

    public Todo createTodo(Todo todo) {
        try {
            db.createTodo(todo);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return searchTodoByText(todo);
    }

    public Todo searchTodoByText(Todo todo) {
        try {
            todo = db.readTodoById(todo);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return todo;
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

    public List<Todo> list() {
        List<Todo> todos = null;
        try {
            todos = db.getAllTodos();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return todos;
    }


    public void markDone(Todo todo) {
        if (todo.getDone() == 0) {
            todo.setDone(1);
        } else todo.setDone(0);
        writeTodoChanges(todo);
    }

    public void changeText(Todo todo, String newText) {
        todo.setText(newText);
        writeTodoChanges(todo);
    }

    private void writeTodoChanges(Todo todo) {
        try {
            db.updateTodo(todo);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void deleteTodo(int index) {
        Todo todo = readTodo(index);
        try {
            db.deleteTodo(todo);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    public void assignToUser() {
    }
}
