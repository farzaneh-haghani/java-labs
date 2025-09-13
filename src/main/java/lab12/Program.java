package lab12;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

import com.google.gson.Gson;

public class Program {
    public static void main(String[] args)  throws Exception{
        try {
            Gson gson = new Gson();

            //Read customers from JSON file
            String fileName = "C:\\Users\\Admin\\Desktop\\farzaneh\\java-labs\\src\\main\\java\\lab12\\src\\customers.json";
            String content = new String(Files.readAllBytes(Path.of(fileName)));
            Customer[] customers = gson.fromJson(content, Customer[].class);

            for(Customer customer:customers){
                System.out.println(customer.getCustomerID());
            }

            //Convert Java objects to JSON
            int[] nos = {1,3,5,7,9};
            String res = gson.toJson(nos);
            System.out.println(res);

            String[] names= {"Bob","Fred","Wilma"};
            res = gson.toJson(names);
            System.out.println(res);

            Student[] students = {
                new Student("Bob",21), 
                new Student("Fred",32), 
                new Student("Wilma",26)
            };
            res = gson.toJson(students);
            System.out.println(res);	


            //Read courses, trainers, and trainersCourses from CSV files
            String[] courses = readCSV(
                    "C:\\Users\\Admin\\Desktop\\farzaneh\\java-labs\\src\\main\\java\\lab12\\src\\course.txt");
            String[] trainers = readCSV(
                    "C:\\Users\\Admin\\Desktop\\farzaneh\\java-labs\\src\\main\\java\\lab12\\src\\trainer.txt");
            String[] trainersCourses = readCSV(
                    "C:\\Users\\Admin\\Desktop\\farzaneh\\java-labs\\src\\main\\java\\lab12\\src\\trainerCourse.txt");
            FileWriter fileWriter = new FileWriter(
                    "C:\\Users\\Admin\\Desktop\\farzaneh\\java-labs\\src\\main\\java\\lab12\\src\\courseTrainer.txt");

            
            //Write course-trainer pairs to file
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
            System.err.println(err);
        } catch (IOException err) {
            System.err.println(err);
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