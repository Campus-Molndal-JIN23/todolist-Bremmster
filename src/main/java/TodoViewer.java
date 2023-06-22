import org.campusmolndal.todo.Todo;

public class TodoViewer {


    public static void viewTodo(Todo todo) {
        if (todo.getId() != 0) {
            System.out.println(todo.toString());
        } else {
            TextManager.thisDontExist();
        }
    }
}
