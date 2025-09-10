package lab12;

import java.io.*;
import java.util.*;

public class Program {
    public static void main(String[] args) {
        try {
            String[] courses = readCSV(
                    "C:\\Users\\Admin\\Desktop\\farzaneh\\java-labs\\src\\main\\java\\lab12\\src\\course.txt");
            String[] trainers = readCSV(
                    "C:\\Users\\Admin\\Desktop\\farzaneh\\java-labs\\src\\main\\java\\lab12\\src\\trainer.txt");
            String[] trainersCourses = readCSV(
                    "C:\\Users\\Admin\\Desktop\\farzaneh\\java-labs\\src\\main\\java\\lab12\\src\\trainerCourse.txt");
            FileWriter fileWriter = new FileWriter(
                    "C:\\Users\\Admin\\Desktop\\farzaneh\\java-labs\\src\\main\\java\\lab12\\src\\courseTrainer.txt");

            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            for (int i = 0; i < trainersCourses.length; i = i + 2) {
                int courseIndex = Integer.parseInt(trainersCourses[i + 1]) - 1;
                int trainerIndex = Integer.parseInt(trainersCourses[i]) - 1;
                bufferedWriter.append(courses[courseIndex]);
                bufferedWriter.append(": ");
                bufferedWriter.append(trainers[trainerIndex]);
                bufferedWriter.append("\n");
            }

            bufferedWriter.close();
        } catch (FileNotFoundException err) {
            System.err.println("ff");
        } catch (IOException err) {
            System.err.println("iii");
        }
    }

    private static String[] readCSV(String inFile) throws IOException {
        FileReader fileReader = new FileReader(inFile);
        BufferedReader bufferReader = new BufferedReader(fileReader);
        String line = bufferReader.readLine();

        ArrayList<String> result = new ArrayList<>();
        while (line != null) {
            String[] temp = line.split(",");
            result.addAll(Arrays.asList(temp));
            line = bufferReader.readLine();
        }
        bufferReader.close();
        String[] courses = result.toArray(new String[0]);
        return courses;
    }
}