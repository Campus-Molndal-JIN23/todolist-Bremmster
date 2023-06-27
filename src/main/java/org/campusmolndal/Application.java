package org.campusmolndal;

import org.campusmolndal.helpers.TextManager;
import org.campusmolndal.helpers.UserInputManager;
import org.campusmolndal.todo.Todo;
import org.campusmolndal.todo.TodoFacade;
import org.campusmolndal.todo.TodoViewer;
import org.campusmolndal.user.User;
import org.campusmolndal.user.UserFacade;
import org.campusmolndal.user.UserViewer;

import java.util.List;

public class Application {

    private final TodoFacade todoFacade;
    private final UserFacade userFacade;
    private User currentUser;

    public Application(TodoFacade todoFacade, UserFacade userFacade) {

        this.todoFacade = todoFacade;
        this.userFacade = userFacade;
        this.currentUser = userFacade.readUser(1); // set user to the fist in database
        mainMenu();
    }

    private void mainMenu() {
        while (true) {
            TextManager.mainMenu();
            switch (UserInputManager.getLimitedInt(1, 2)) {
                case 1 -> todoMenu();
                case 2 -> userMenu();
                case 9 -> System.exit(0);
            }
        }
    }

    private void todoMenu() {
        while (true) {
            TextManager.todoMenu(currentUser);
            switch (UserInputManager.getLimitedInt(1, 7)) {
                case 1 -> createTodo();
                case 2 -> readTodo();
                case 3 -> updateTodo();
                case 4 -> deleteTodo();
                case 5 -> listAllTodos(todoFacade.list());
                case 6 -> listAllTodos(todoFacade.listUserTodos(currentUser)); // List current user tasks
                case 7 -> changeUser();
                case 9 -> {
                    return;
                }
            }
        }
    }

    private void changeUser() {
        TextManager.changeUserSelectId();
        this.currentUser = userFacade.changeUser(currentUser, UserInputManager.getInt());
    }

    private void listAllTodos(List<Todo> todoFacade) {
        if (todoFacade != null) {
            for (Todo todo : todoFacade) {
                TodoViewer.viewTodo(todo);
            }
        }
    }

    private void deleteTodo() {
        TextManager.indexOfTodo("delete");
        todoFacade.deleteTodo(UserInputManager.getInt());
    }

    private void updateTodo() {
        TextManager.indexOfTodo("update");
        updateTodo(todoFacade.readTodo(UserInputManager.getInt()));
    }

    private void readTodo() {
        TextManager.indexOfTodo("view");
        TodoViewer.viewTodo(todoFacade.readTodo(UserInputManager.getInt()));
    }

    private void createTodo() {
        TextManager.todoNewText();
        Todo todo = new Todo(UserInputManager.getString());
        TodoViewer.viewTodo(todoFacade.createTodo(todo, currentUser));
    }

    private void updateTodo(Todo todo) {
        while (true) {
            TodoViewer.viewTodo(todo);
            TextManager.updateTodoMenu(currentUser);
            switch (UserInputManager.getLimitedInt(1, 3)) {
                case 1 -> todoFacade.markDone(todo); // mark done / not done
                case 2 -> changeTodoText(todo);
                case 3 -> todoFacade.assignToUser(todo, currentUser); // assign to user
                case 9 -> {
                    return;
                }
            }
        }
    }

    private void changeTodoText(Todo todo) {
        TextManager.todoNewText();
        todoFacade.changeText(todo, UserInputManager.getString());
    }

    private void userMenu() {
        // todo
        while (true) {
            TextManager.userMenu();
            switch (UserInputManager.getLimitedInt(1, 3)) {
                case 1 -> createUser();
                case 2 -> updateUser();
                case 3 -> listAllUsers();
                case 9 -> {
                    return;
                }
            }
        }
    }

    private void listAllUsers() {
        List<User> users = userFacade.list();
        if (users != null) {
            for (User user : users) {
                UserViewer.viewUser(user);
            }
        }
    }

    private void updateUser() {
        TextManager.indexOfUser("update"); // todo
        updateUser(userFacade.readUser(UserInputManager.getInt()));
    }

    private void createUser() {
        TextManager.userNewName();
        User user = new User(UserInputManager.getString());

        changeUserAge(user);

    }

    private void updateUser(User user) {
        while (true) {
            UserViewer.viewUser(user);
            TextManager.updateUserMenu(currentUser);
            switch (UserInputManager.getLimitedInt(1, 2)) {
                case 1 -> changeUserName(user);
                case 2 -> changeUserAge(user);
                case 9 -> {
                    return;
                }
            }
        }
    }

    private void changeUserAge(User user) {
        final int MIN = 0;
        final int MAX = 150;
        TextManager.userNewAge();
        userFacade.changeAge(user, UserInputManager.getLimitedInt(MIN, MAX));
    }

    private void changeUserName(User user) {
        TextManager.userNewName();
        userFacade.changeName(user, UserInputManager.getString());
    }
}

