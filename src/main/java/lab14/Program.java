package lab14;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class Program {
    public static void main(String[] args) {
        String customerJsonFile = "C:\\Users\\Admin\\Desktop\\farzaneh\\java-labs\\src\\main\\java\\lab14\\src\\customers.json";
        try {
            List<Customer> customers = JSONReader.readCustomers(customerJsonFile);

            String targetCity = "London";
            List<Customer> filteredCustomers = CustomerFilter.filterByCity(customers, targetCity);

            System.out.println("Customer in " + targetCity + ":");
            filteredCustomers
                    .forEach(customer -> System.out.println(customer.getName() + "(ID:" + customer.getId() + ""));

            String libraryJsonFile = "C:\\Users\\Admin\\Desktop\\farzaneh\\java-labs\\src\\main\\java\\lab14\\src\\library.json";
            String libraryString = new String(Files.readAllBytes(Paths.get(libraryJsonFile)));
            Library library = JSONReader.readLibrary(libraryString);

            System.out.println("Libray of '" + library.getName() + "' has books:");
            library.getBooks()
                    .forEach(book -> System.out.println("Title: " + book.getTitle() + " | Author: " + book.getAuthor()
                            + " | Avaiablity: " + (book.getAvailable() ? "Yes" : "No")));

        } catch (IOException err) {
            System.err.printf("Error reading the JSON file: %s\n", err.getMessage());
        }
    }
}
