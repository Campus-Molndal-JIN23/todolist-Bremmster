package org.campusmolndal;
import org.campusmolndal.todo.TodoFacade;
import org.campusmolndal.user.UserFacade;

public class Main {

    public static void main(String[] args) {
        Application todoApp = new Application(new TodoFacade(), new UserFacade());
    }
}
