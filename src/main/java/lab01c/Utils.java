package lab01c;

import java.util.Scanner;

public class Utils {
    public int getInt(String prompt, Scanner scanner) {
        Integer num = null;
        System.out.println(prompt);
        while (num == null) {
            try {
                String temp = scanner.nextLine();
                num = Integer.parseInt(temp);
            } catch (NumberFormatException error) {
                System.out.println(prompt);
            }
        }
        return num;
    }

    public String getString(String prompt, Scanner scanner) {
        System.out.println(prompt);
        String input = scanner.nextLine().trim();
        return input;
    }
}
