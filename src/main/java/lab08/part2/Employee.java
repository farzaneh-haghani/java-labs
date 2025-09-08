package lab08.part2;

public class Employee {
    private int id;
    private static int idCount;
    private String jobTitle;
    private String name;

    public Employee(String name, String jobTitle) {
        this.jobTitle = jobTitle;
        this.name = name;
        setId(Employee.idCount++);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getInfo() {
        String info = "\n**** *****\n";
        info += "Name:" + getName() + "\n";
        info += "Job Title:" + getJobTitle() + "\n";
        info += "Employee ID:" + getId() + "\n";
        return info;
    }

}
