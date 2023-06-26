package org.campusmolndal.helpers;


import java.util.Scanner;

public class UserInputManager {

    private final static Scanner scanner = new Scanner(System.in);


    public static int menuChoice(int min, int max) {
        int input = getInt();
        if (input >= min && input <= max || input == 9) {
            return input;
        } else {
            TextManager.notValidChoice();
            return menuChoice(min, max);
        }
    }

    public static int getInt() {
        int input;
        while (true) {
            try {
                input = Integer.parseInt(scanner.nextLine());
                break;
            } catch (NumberFormatException e) {
                TextManager.notValidInt();
            }
        }
        return input;
    }

    public static String getString() {
        return scanner.nextLine();
    }
}
