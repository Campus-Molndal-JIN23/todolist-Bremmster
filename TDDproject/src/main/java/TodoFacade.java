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

    public TodoFacade(TodoDatabase db) { // this constructor exists to enable testing
        this.db = db;
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

    public void markDone(Todo todo) {
        if (todo.getDone() == 0) {
            todo.setDone(1);
        } else todo.setDone(0);
        // System.out.println("status set to " + todo.getDone());
        writeTodoChanges(todo);
    }

    public void changeText(Todo todo, String newText) {
        todo.setText(newText);
        writeTodoChanges(todo);
        // System.out.println("new text: " + todo.getText());
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
