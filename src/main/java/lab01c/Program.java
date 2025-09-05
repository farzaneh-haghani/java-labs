package lab01c;

import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        theLunchQueue(scanner);
        Integer weightInPound = null;
        while (weightInPound == null) {
            System.out.println("Please enter a weight in pound:");
            try {
                String temp = scanner.nextLine();
                weightInPound = Integer.parseInt(temp);
            } catch (NumberFormatException err) {
            }
        }
        convertInputToStonesPounds(weightInPound);
        convertKgstoStonesPounds(scanner);
        scanner.close();
    }

    public static void theLunchQueue(Scanner scanner) {
        Utils utils = new Utils();
        String mainCourse;
        do {
            mainCourse = utils.getString("What main dish would you like(Fish, Burgers or Veg)?", scanner);
        } while (!(mainCourse.equalsIgnoreCase("Fish") || mainCourse.equalsIgnoreCase("Burgers")
                || mainCourse.equalsIgnoreCase("Veg")));
        Integer potatoes = utils.getInt("How many roast potatoes would you like?", scanner);
        Integer sprouts = utils.getInt("How many Brussel Sprouts would you like?", scanner);
        System.out.printf("Hello, your lunch is %s with %d roast potatoes and %d Brussel sprouts.\n", mainCourse,
                potatoes, sprouts);
    }

    public static void convertInputToStonesPounds(Integer pounds) {
        Integer stones = pounds / 14;
        Integer reminder = pounds % 14;
        System.out.printf("There are %d stones and %d pounds remind.\n", stones, reminder);
    }

    public static void convertKgstoStonesPounds(Scanner scanner) {
        Integer weightInKg = null;
        while (weightInKg == null) {
            System.out.println("Please enter a weight in Kilogram:");
            try {
                String temp = scanner.nextLine();
                weightInKg = Integer.parseInt(temp);
            } catch (NumberFormatException err) {
            }
        }
        Integer pound = (int) (weightInKg * 2.20462);
        convertInputToStonesPounds(pound);
    }
}
