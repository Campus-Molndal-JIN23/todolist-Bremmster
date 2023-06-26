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
            switch (UserInputManager.menuChoice(1, 2)) {
                case 1 -> todoMenu();
                case 2 -> userMenu();
                case 9 -> System.exit(0);
            }
        }
    }

    private void todoMenu() {
        while (true) {
            TextManager.todoMenu(currentUser);
            switch (UserInputManager.menuChoice(1, 7)) {
                case 1 -> { // Create
                    TextManager.todoNewText();
                    Todo todo = new Todo(UserInputManager.getString());
                    TodoViewer.viewTodo(todoFacade.createTodo(todo, currentUser));
                }
                case 2 -> { // Read
                    TextManager.indexOfTodo("view");
                    TodoViewer.viewTodo(todoFacade.readTodo(UserInputManager.getInt()));
                }
                case 3 -> { // Update
                    TextManager.indexOfTodo("update");
                    updateTodo(todoFacade.readTodo(UserInputManager.getInt()));
                }
                case 4 -> { // Delete
                    TextManager.indexOfTodo("delete");
                    todoFacade.deleteTodo(UserInputManager.getInt());
                }
                case 5 -> { // List all tasks
                    List<Todo> todos = todoFacade.list();
                    if (todos != null) {
                        for (Todo todo : todos) {
                            TodoViewer.viewTodo(todo);
                        }
                    }
                }
                case 6 -> { // List current user tasks
                    List<Todo> todos = todoFacade.listUsersTodos(currentUser);
                    if (todos != null) {
                        for (Todo todo : todos) {
                            TodoViewer.viewTodo(todo);
                        }
                    }
                }
                case 7 -> { // Change user
                    TextManager.changeUserSelectId();
                    this.currentUser = userFacade.changeUser(currentUser, UserInputManager.getInt());
                }
                case 9 -> {
                    return;
                }
            }
        }
    }

    private void updateTodo(Todo todo) {
        while (true) {
            TodoViewer.viewTodo(todo);
            TextManager.updateTodoMenu(currentUser);
            switch (UserInputManager.menuChoice(1, 3)) {
                case 1 -> todoFacade.markDone(todo); // mark done / not done
                case 2 -> { // change text
                    TextManager.todoNewText();
                    todoFacade.changeText(todo, UserInputManager.getString());
                }
                case 3 -> todoFacade.assignToUser(todo, currentUser); // assign to user
                case 9 -> {
                    return;
                }
            }
        }
    }

    private void userMenu() {
        // todo
        while (true) {
            TextManager.userMenu();
            switch (UserInputManager.menuChoice(1, 3)) {
                case 1 -> { // create user
                    TextManager.userNewName();
                    User user = new User(UserInputManager.getString());
                    TextManager.userNewAge();
                    user.setAge(UserInputManager.getInt());

                    // todo skapa en metod för att lägga till i databasen
                    UserViewer.viewUser(userFacade.createUser(user));
                }
                case 2 -> { // Update user
                    TextManager.indexOfUser("update"); // todo
                    updateUser(userFacade.readUser(UserInputManager.getInt()));
                }
                case 3 -> { // List users
                    List<User> users = userFacade.list();
                    if (users != null) {
                        for (User user : users) {
                            UserViewer.viewUser(user);
                        }
                    }
                }
                case 9 -> {
                    return;
                }
            }
        }
    }

    private void updateUser(User user) {
        while (true) {
            UserViewer.viewUser(user);
            TextManager.updateUserMenu(currentUser);
            switch (UserInputManager.menuChoice(1, 2)) {
                case 1 -> { // change name of user
                    TextManager.userNewName();
                    userFacade.changeName(user, UserInputManager.getString());
                }
                case 2 -> { // change age of user
                    TextManager.userNewAge();
                    userFacade.changeAge(user, UserInputManager.getInt());
                }
                case 9 -> {
                    return;
                }
            }
        }
    }
}

