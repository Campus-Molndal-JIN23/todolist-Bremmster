package org.campusmolndal.todo;

import java.util.List;

public class TodoFacade {
    // hanterar objekten och databasen
    private final TodoDatabase db;

    public TodoFacade() {
        this.db = new TodoDatabase();
    }

    public TodoFacade(TodoDatabase db) { // this constructor exists to enable testing
        this.db = db;
    }

    public Todo createTodo(Todo todo) {
        db.createTodo(todo);
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
        List<Todo> todos = null;
        todos = db.getAllTodos();
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

        db.updateTodo(todo);

    }

    public void deleteTodo(int index) {
        Todo todo = readTodo(index);
        db.deleteTodo(todo);
    }


    public void assignToUser() {
    }
}
