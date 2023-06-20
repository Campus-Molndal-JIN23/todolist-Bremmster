import java.util.InputMismatchException;
import java.util.Scanner;

public class UserInputManager {

    private final static Scanner scanner = new Scanner(System.in);


    public static int menuChoice(int min, int max) {
        // todo remove static?
        int input = getInt();
        if (input >= min && input <= max || input == 9) {
            return input;
        } else {
            return menuChoice(min, max);
        }
    }

    private static int getInt() {
        int input;
        while (true) {
            try {
                input = Integer.parseInt(scanner.nextLine());
                break;
            } catch (InputMismatchException e) {
                System.out.print("Not an Integer\nPleaser enter Integer: ");
                getInt();
            }
        }
        return input;
    }

    public String getString() {
        return scanner.nextLine();
        // todo try catch
    }
}
