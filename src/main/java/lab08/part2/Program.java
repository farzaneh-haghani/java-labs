package lab08.part2;

public class Program {
    public static void main(String[] args) {
        Manager manager = new Manager("My Manager", "Manager");
        Employee employee1 = new Employee("employee1", "Junior Solution Engineer");
        Employee employee2 = new Employee("employee2", "Solution Engineer");
        Employee employee3 = new Employee("employee3", "Senior Solution Engineer");

        manager.addEmployee(employee1);
        manager.addEmployee(employee2);
        manager.addEmployee(employee3);

        Employee skilledWorker = new SkilledWorker("skillworker1", "Junior DevOps Engineer");
        ((SkilledWorker) skilledWorker).addSkill("Terraform");
        ((SkilledWorker) skilledWorker).addSkill("Kubernetise");

        manager.addEmployee(skilledWorker);
        String result = manager.getInfo();
        System.out.println(result);
    }
}
