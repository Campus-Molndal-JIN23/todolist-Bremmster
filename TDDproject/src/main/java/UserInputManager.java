import java.util.InputMismatchException;
import java.util.Scanner;

public class UserInputManager {

    private static Scanner scanner;

    public UserInputManager() {
        this.scanner = new Scanner(System.in);
    }

    public String getString() {
        return scanner.nextLine();
        // todo try catch
    }

    public static int menuChoice(int min, int max) {
        int usrChoice;

        while (true) {
            try {
                usrChoice = Integer.parseInt(scanner.nextLine());
                if (usrChoice >= min && usrChoice <= max || usrChoice == 9) break;
            } catch (InputMismatchException e) {
                System.out.print("Not an Integer\nPleaser enter Integer: ");
                scanner.nextLine(); // to eat the line feed that nextInt misses
            }
        }
        return usrChoice;
    }
}
