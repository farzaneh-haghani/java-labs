package lab06;

public class Program {
    public static void main(String[] args) {
        Account myAccount = new Account(123, 100, "Farzaneh");
        StringBuilder details = new StringBuilder();
        try {
            myAccount.withraw(50);
            details.append(myAccount.getDetails());
            System.out.println(details);

            myAccount.withraw(60);
            details.replace(0, details.length(), myAccount.getDetails());
            System.out.println(details);
        } catch (IllegalArgumentException err) {
            System.err.printf("Negative balance: ", err.getMessage());
        } finally {
            myAccount.close();
        }

    }
}
