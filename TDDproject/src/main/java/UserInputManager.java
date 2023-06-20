import java.util.InputMismatchException;
import java.util.Scanner;

public class UserInputManager {

    private static Scanner scanner = new Scanner(System.in);


    public static int menuChoice(int min, int max) {
        // todo remove static?
        int usrChoice;

        while (true) {
            try {
                usrChoice = Integer.parseInt(scanner.nextLine());
                // todo check i this works
                if (usrChoice >= min && usrChoice <= max || usrChoice == 9) break;
            } catch (InputMismatchException e) {
                System.out.print("Not an Integer\nPleaser enter Integer: ");
                scanner.nextLine(); // to eat the line feed that nextInt misses
            }
        }
        return usrChoice;
    }

    public String getString() {
        return scanner.nextLine();
        // todo try catch
    }
}
