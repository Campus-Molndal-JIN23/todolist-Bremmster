import java.sql.SQLException;

public class Application {

    private TodoFacade todoFacade;

    public Application(TodoFacade todoFacade) throws SQLException {
        this.todoFacade = todoFacade;
        mainMenu();
    }

    private void mainMenu() throws SQLException {
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
                case 1 -> todoFacade.createTodo();
                case 2 -> {
                    TextManager.indexOfTodo("view");
                    todoFacade.readTodo(UserInputManager.getInt());
                }
                case 3 -> {
                    TextManager.indexOfTodo("update");
                    updateTodo(todoFacade.readTodo(UserInputManager.getInt()));
                }
                case 4 -> {
                    TextManager.indexOfTodo("delete");
                    todoFacade.deleteTodo();
                }
                case 9 -> {
                    return;
                }
            }
        }
    }

    private void updateTodo(Todo todo) {
        while (true) {
            TextManager.updateMenu();
            switch (UserInputManager.menuChoice(1, 3)) {
                case 1 -> todo.markDone();
                case 2 -> todo.changeText();
                case 3 -> assignToUser();
                case 9 -> {
                    return;
                }
            }
        }
    }

    private void assignToUser() {

    }

    private void changeText() {

    }

    private void markDone() {

    }

    private void userMenu() {
        // todo
    }
}

