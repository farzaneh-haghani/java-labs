package lab08.part2;

import java.util.ArrayList;

public class Manager extends Employee {
    private ArrayList<Employee> employees;

    public Manager(String name, String jobTitle) {
        super(name, jobTitle);
        this.employees = new ArrayList<>();

    }

    public ArrayList<Employee> getEmployees() {
        return employees;
    }

    public void addEmployee(Employee emp) {
        employees.add(emp);
    }

    public String getInfo() {
        String result;
        result = super.getInfo() + "\n";
        for (Employee employee : employees) {
            result += employee.getInfo();
        }
        return result;
    }

}
