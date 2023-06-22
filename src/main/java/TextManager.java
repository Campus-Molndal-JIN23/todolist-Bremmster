public class TextManager {



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

    public static void todoMenu() {
        System.out.println("+---------------------------------------+");
        System.out.println("| TODO                                  |");
        System.out.println("+---------------------------------------+");
        System.out.println("| 1) Create a todo                      |");
        System.out.println("| 2) Read a todo                        |");
        System.out.println("| 3) Update a todo                      |");
        System.out.println("| 4) Delete a todo                      |");
        System.out.println("| 5) List all todo                      |");
        System.out.println("| 5) Change user                        |");
        System.out.println("| 9) goto overhead menu                 |");
        System.out.println("+---------------------------------------+");
        System.out.print("Enter a option: ");
    }

    public static void updateMenu() {
        System.out.println("+---------------------------------------+");
        System.out.println("| Update todo                           |");
        System.out.println("+---------------------------------------+");
        System.out.println("| 1) Toggle done/ not done              |");
        System.out.println("| 2) Change text                        |");
        System.out.println("| 3) Assign to other user               |");
        System.out.println("| 9) goto overhead menu                 |");
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
        System.out.println("Not a valid choice. Better luck next time");
    }
    public static void thisDontExist() {
        System.out.println("No todo with that index");
    }

    public void userMenu() {
        System.out.println("+---------------------------------------+");
        System.out.println("| User                                  |");
        System.out.println("+---------------------------------------+");
        System.out.println("| 1) Create a user                      |");
        System.out.println("| 2) Update username                    |");
        System.out.println("| 3) Search for user                    |");
        System.out.println("| 4) List all users                     |");
        System.out.println("| 9) goto overhead menu                 |");
        System.out.println("+---------------------------------------+");
        System.out.print("Enter a option: ");
    }
}
