package org.campusmolndal.todo;

import org.campusmolndal.DatabaseHandler;
import org.campusmolndal.user.User;

import java.util.List;

public class TodoFacade {
    private final DatabaseHandler db;

    public TodoFacade() {
        this.db = DatabaseHandler.getInstance();
    }

    public TodoFacade(DatabaseHandler db) {
        // this constructor exists to enable testing
        this.db = db;
    }

    public Todo createTodo(Todo todo, User currentUser) {
        db.createTodo(todo, currentUser);
        return searchTodoByText(todo);
    }

    public Todo searchTodoByText(Todo todo) {
        todo = db.readTodoById(todo);
        return todo;
    }

    public Todo readTodo(int index) {
        Todo todo;
        todo = db.readTodoById(index);
        return todo;
    }

    public List<Todo> list() {
        List<Todo> todos;
        todos = db.getAllTodos();
        return todos;
    }

    public List<Todo> listUserTodos(User currentUser) {
        List<Todo> todos;
        todos = db.getAllUserTodos(currentUser);
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
        boolean hereToMakeATestPossible = db.updateTodo(todo);
    }

    public void deleteTodo(int index) {
        Todo todo = readTodo(index);
        db.deleteTodo(todo);
    }


    public void assignToUser(Todo todo, User currentUser) {
        todo.setAssignedTo(currentUser.getId());
        writeTodoChanges(todo);
    }
}
