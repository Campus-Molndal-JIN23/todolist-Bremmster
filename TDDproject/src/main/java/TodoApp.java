public class TodoApp {


    public TodoApp() {
        mainMenu();
    }

    private void mainMenu() {
        MenuTextManager.mainMenu();
        switch (UserInputManager.menuChoice(1, 2)) {
            case 1 -> todoMenu();
            case 2 -> userMenu();
            case 9 -> System.exit(0);
        }
    }

    private void todoMenu() {
        MenuTextManager.todoMenu();
        switch (UserInputManager.menuChoice(1, 5)) {
            case 1 -> createTodo();
            case 2 -> readTodo();
            case 3 -> updateTodo();
            case 4 -> deleteTodo();
            case 9 -> {
                return;
            }
        }
    }

    private void deleteTodo() {

    }

    private void readTodo() {

    }

    private void createTodo() {

    }

    private void updateTodo() {
        MenuTextManager.updateMenu();
        switch (UserInputManager.menuChoice(1, 3)) {
            case 1 -> markDone();
            case 2 -> changeText();
            case 3 -> assignToUser();
            case 9 -> {
                return;
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

