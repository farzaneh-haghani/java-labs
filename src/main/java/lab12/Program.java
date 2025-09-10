package lab12;

import java.io.*;

public class Program {
    public static void main(String[] args) {
        try {
            String[] courses = readCSV(
                    "C:\\Users\\Admin\\Desktop\\farzaneh\\java-labs\\src\\main\\java\\lab12\\src\\course.txt");
            String[] trainers = readCSV(
                    "C:\\Users\\Admin\\Desktop\\farzaneh\\java-labs\\src\\main\\java\\lab12\\src\\trainer.txt");
            FileWriter fileWriter = new FileWriter(
                    "C:\\Users\\Admin\\Desktop\\farzaneh\\java-labs\\src\\main\\java\\lab12\\src\\courseTrainer.txt");
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            for (int i = 0; i < courses.length; i++) {
                bufferedWriter.append(courses[i]);
                bufferedWriter.append(": ");
                bufferedWriter.append(trainers[i]);
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
        StringBuilder result = new StringBuilder();
        while (line != null) {
            result.append(line);
            line = bufferReader.readLine();
        }
        bufferReader.close();
        String[] courses = result.toString().split(",");
        return courses;
    }
}
