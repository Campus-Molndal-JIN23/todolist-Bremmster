package org.campusmolndal.helpers;

import org.campusmolndal.todo.Todo;
import org.campusmolndal.todo.TodoViewer;
import org.campusmolndal.user.User;

public class TextManager {


    public static void userNewName() {
        System.out.print("Set username: ");
    }

    public static void userNewAge() {
        System.out.print("Set user age: ");
    }

    public static void notValidData() {
        System.out.println("Sorry i wont allow that");
    }

    public void welcome() {
        System.out.println("Welcome to todo list app");
    }

    public static void mainMenu() {
        System.out.println("+---------------------------------------+");
        System.out.println("| Main menu                             |");
        System.out.println("+---------------------------------------+");
        System.out.println("| 1) Todo                               |");
        System.out.println("| 2) User                               |");
        System.out.println("| 9) Exit                               |");
        System.out.println("+---------------------------------------+");
        System.out.print("Enter a option: ");
    }

    public static void todoMenu(User currentUser) {
        System.out.println("+---------------------------------------+");
        System.out.println("| TODO | Current user: " + currentUser.getName());
        System.out.println("+---------------------------------------+");
        System.out.println("| 1) Create a todo                      |");
        System.out.println("| 2) Read a todo                        |");
        System.out.println("| 3) Update a todo                      |");
        System.out.println("| 4) Delete a todo                      |");
        System.out.println("| 5) List all todo                      |");
        System.out.println("| 6) List current users todos           |");
        System.out.println("| 7) Change user                        |");
        System.out.println("| 9) goto overhead menu                 |");
        System.out.println("+---------------------------------------+");
        System.out.print("Enter a option: ");
    }

    public static void updateTodoMenu(User currentUser, Todo todo) {
        System.out.println("+---------------------------------------+");
        System.out.println("| Update todo | Current user: " + currentUser.getName());
        System.out.print("| current todo: "); TodoViewer.viewTodo(todo);
        System.out.println("+---------------------------------------+");
        System.out.println("| 1) Toggle done/ not done              |");
        System.out.println("| 2) Change text                        |");
        System.out.println("| 3) Assign to current user               |");
        System.out.println("| 9) goto overhead menu                 |");
        System.out.println("+---------------------------------------+");
        System.out.print("Enter a option: ");
    }

    public static void indexOfTodo(String msg) {
        System.out.println("index of todo to " + msg);
    }
    public static void todoNewText() {
        System.out.println("Enter text for new todo ");
    }

    public static void notValidInt() {
        System.out.print("Not an Integer\nPleaser enter Integer: ");
    }

    public static void notValidChoice() {
        System.out.println("Not a valid choice. Better luck next time \nPlease try again: ");
    }
    public static void thisDontExist() {
        System.out.println("Nothing with that index");
    }
    public static void indexOfUser(String msg) {
        System.out.println("index of user to: " + msg);
    }

    public static void  changeUserSelectId() {
        System.out.println("Change user select id: ");
    }

    public static void userMenu(User currentUser) {
        System.out.println("+---------------------------------------+");
        System.out.println("| User | Current user: " + currentUser.getName());
        System.out.println("+---------------------------------------+");
        System.out.println("| 1) Create a user                      |");
        System.out.println("| 2) Update user                        |");
        System.out.println("| 3) List all users                     |");
        System.out.println("| 9) goto overhead menu                 |");
        System.out.println("+---------------------------------------+");
        System.out.print("Enter a option: ");
    }
    public static void updateUserMenu(User currentUser) {
        System.out.println("+---------------------------------------+");
        System.out.println("| Update user | Current user: " + currentUser.getName());
        System.out.println("+---------------------------------------+");
        System.out.println("| 1) Update name                        |");
        System.out.println("| 2) Update age                         |");
        System.out.println("| 9) goto overhead menu                 |");
        System.out.println("+---------------------------------------+");
        System.out.print("Enter a option: ");
    }
}
