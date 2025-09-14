package lab15;

public class Program {

    private static final String FILE_NAME = "C:\\Users\\Admin\\Desktop\\farzaneh\\java-labs\\src\\main\\java\\lab15\\shared_file.txt";

    public static void main(String[] args) {

        for (int i = 0; i < 3; i++) {
            String message = String.format("Thread %d's message", i);
            WorkerThread workerThread1 = new WorkerThread(FILE_NAME, message);
            Thread t = new Thread(workerThread1);

            t.start();
        }

    }
}
