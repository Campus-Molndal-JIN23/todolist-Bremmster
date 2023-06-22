import java.util.List;

public class Application {

    private TodoFacade todoFacade;

    public Application(TodoFacade todoFacade) {

        this.todoFacade = todoFacade;
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
            TextManager.todoMenu();
            switch (UserInputManager.menuChoice(1, 5)) {
                case 1 -> {
                    TextManager.todoNewText();
                    Todo todo = new Todo(UserInputManager.getString());
                    TodoViewer.viewTodo(todoFacade.createTodo(todo));
                }
                case 2 -> {
                    TextManager.indexOfTodo("view");
                    TodoViewer.viewTodo(todoFacade.readTodo(UserInputManager.getInt()));
                }
                case 3 -> {
                    TextManager.indexOfTodo("update");
                    updateTodo(todoFacade.readTodo(UserInputManager.getInt()));
                }
                case 4 -> {
                    TextManager.indexOfTodo("delete");
                    todoFacade.deleteTodo(UserInputManager.getInt());
                }
                case 5 -> {
                    List<Todo> todos = todoFacade.list();
                    if (todos != null) {
                        for (Todo todo : todos) {
                            TodoViewer.viewTodo(todo);
                        }
                    }
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
            TextManager.updateMenu(); // todo lägg till att objektet visas i menyn
            switch (UserInputManager.menuChoice(1, 3)) {
                case 1 -> todoFacade.markDone(todo);
                case 2 -> {
                    TextManager.todoNewText();
                    todoFacade.changeText(todo, UserInputManager.getString());
                }
                case 3 -> todoFacade.assignToUser();
                case 9 -> {
                    return;
                }
            }
        }
    }

    private void userMenu() {
        // todo
    }
}

