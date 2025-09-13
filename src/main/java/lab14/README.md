<h1>Lab 14</h1>h1>

Streams and Lambda
 
Lab: Working Lambda and streams
Objective 
In Java, streams are a modern and efficient way to process data. In this lab, you will use the java.util.stream package to perform operations such as filtering, mapping, and reducing on data collections like lists in a functional programming style.

Part 1 – Start by reading data from a source  
Let’s start by reading JSON data from a data source such as file to simulate a real-life scenario. This will also serve as a helpful review of the techniques you've learnt throughout this course.
1. Back in the labs project, add a new class called Program with a main() method in a package called lab14.
2. Create a file called customers.json in c:\labs as:
   
```
[
   {
        "id": 1,
        "name": "Alice Johnson",
        "city": "London"
    },
    {
        "id": 2,
        "name": "Bob Smith",
        "city": "Bristol"
    },
    {
        "id": 3,
        "name": "Charlie Brown",
        "city": "London"
    },
]
```

3. We need to create a class to read the id, name, and city values from customers.json file. Add a new class to your project as:

```java
    public class Customer
    {
        private int id;
        private String name;
        private String city;

        // Getters and Setters
        public int getId() { return id; }
        public void setId(int id) { this.id = id; }
        public String getName() { return name; }
        public void setName(String name) { this.name = name; }
        public String getCity() { return city; }
        public void setCity(String city) { this.city = city; }
    }
```

4. To filter customers, you will create a class that has the code to filter a List of customers. Create a class in your project as:

```java
import java.util.List;
import java.util.stream.Collectors;

public class CustomerFilter   {
   public static List<Customer> filterByCity(List<Customer> customers,  
                                                         String city)
   {
            return customers.stream()
                    .filter(customer-> 
                                customer.getCity().equalsIgnoreCase(city))
                    .collect(Collectors.toList());
        }
    }
```

5. Create another class file to read JSON data and return it as a List<Customer>.

```java
import java.io.File;
import java.io.IOException;
import java.util.List;

public class JSONReader
{
    public static List<Customer> readCustomers(String filePath) 
                                            throws IOException
    {
        ObjectMapper mapper = new ObjectMapper();
	        return mapper.readValue(new File(filePath),        
                                new TypeReference<List<Customer>>() {
	    });
}
```

Let’s put it all together!
Back in the Program main() method type:

```java
public static void main(String[] args)
{
    String jsonFile = "C:\\labs\\customers.json";
    try
    {
        // Read the JSON file
        List<Customer> customers = JSONReader.readCustomers(jsonFile);

        // Filter customers by city
        String targetCity = "London";
        List<Customer> filteredCustomers = 
                                   CustomerFilter.filterByCity(customers, targetCity);

        // Display the filtered customers
        System.out.println("Customers in " + targetCity + ":");
        filteredCustomers.forEach(customer->
            System.out.println(customer.getName() + " (ID: " + customer.getId() + ")")
        );
    }
    catch (IOException e)
    {
        System.err.println("Error reading the JSON file: " + e.getMessage());
    }
}
```
Time to experiment. Please go ahead and modify the code for other JSON files. You may get many JSON samples from the web such as https://jsoning.com/examples/.

** End **
 


