package lab15;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class WorkerThread implements Runnable {

    private final String fileName;
    private final String message;

    public WorkerThread(String fileName, String message) {
        this.fileName = fileName;
        this.message = message;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " is start writing...");
        writeToFile();
        System.out.println(Thread.currentThread().getName() + " wrote the message.");

    }

    public synchronized void writeToFile() {
        try {
            FileWriter fileWriter = new FileWriter(fileName, true);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write(message);
            bufferedWriter.newLine();
            System.out.println(Thread.currentThread().getName() + " is writing");
            bufferedWriter.close();
        } catch (IOException err) {
            err.printStackTrace();
            System.err.printf("Error: %s", err);
        }
    }
}
