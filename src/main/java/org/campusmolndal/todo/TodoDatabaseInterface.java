package org.campusmolndal.todo;

import java.util.List;

public interface TodoDatabaseInterface {

    void createTodo(Todo todo);

    Todo readTodoById(int id);

    void updateTodo(Todo todo);

    void deleteTodo(Todo todo);

    Todo readTodoById(Todo todo);

    List<Todo> getAllTodos();
}
