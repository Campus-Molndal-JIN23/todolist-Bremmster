import org.campusmolndal.todo.TodoFacade;

public class Main {

    public static void main(String[] args) {
        Application todoApp = new Application(new TodoFacade(), new UserFacade());
    }
}
