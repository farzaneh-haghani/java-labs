package lab01d;

public class Program {
    public static void main(String[] args) {
        int[] numbers = { 1, 3, -5, 7, 0, 4, 6, 8 };
        int sum = 0;
        int min = numbers[0];
        int max = numbers[0];
        int zeroIndex = -1;
        for (int i = 0; i < numbers.length; i++) {
            sum += numbers[i];
            if (min > numbers[i]) {
                min = numbers[i];
            }
            if (max < numbers[i]) {
                max = numbers[i];
            }
            if (numbers[i] == 0) {
                zeroIndex = i;
            }
        }
        Double average = (double) (sum / numbers.length);
        System.out.printf("The sum is %d, average is %.2f, minimum is %d, maximum is %d, index of zero is %d\n", sum,
                average, min, max, zeroIndex);
        String[] names = { "name1", "name2", "name3", "name4", "name5" };
        int[] marks = { 20, 55, 64, 89, 115 };
        for (int i = 0; i < marks.length; i++) {
            String grade = getGrade(marks[i]);
            System.out.printf("%s grade: %s\n", names[i], grade);
        }

    }

    public static String getGrade(int mark) {
        String grade = null;
        if (mark < 1 || mark > 100) {
            grade = "Error: marks must be between 1..100";
        } else if (mark < 50) {
            grade = "Fail";
        } else if (mark >= 50 && mark <= 60) {
            grade = "Pass";
        } else if (mark >= 61 && mark <= 70) {
            grade = "Merit";
        } else {
            grade = "Distinction";
        }
        return grade;
    }

}
