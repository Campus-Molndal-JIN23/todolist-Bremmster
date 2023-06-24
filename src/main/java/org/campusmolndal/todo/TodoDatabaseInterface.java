package org.campusmolndal.todo;

import org.campusmolndal.user.User;

import java.util.List;

public interface TodoDatabaseInterface {

    void createTodo(Todo todo, User currentUser);

    Todo readTodoById(int id);

    void updateTodo(Todo todo);

    void deleteTodo(Todo todo);

    Todo readTodoById(Todo todo);

    List<Todo> getAllTodos();
}
