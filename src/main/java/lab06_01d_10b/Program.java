package lab06_01d_10b;

import java.util.*;

public class Program {
    public static void main(String[] args) {
        Account myAccount = new Account(123, "Farzaneh", 100);
        StringBuilder details = new StringBuilder();
        try {
            myAccount.withraw(50);
            details.append(myAccount.getDetails());
            System.out.println(details);

            myAccount.withraw(60);
            details.replace(0, details.length(), myAccount.getDetails());
            System.out.println(details);
        } catch (IllegalArgumentException err) {
            System.err.println(err.getMessage());
        } finally {
            myAccount.close();
        }

        ArrayList<Account> accounts = new ArrayList<>();
        accounts.add(new Account(100, "Linda", 1000));
        accounts.add(new Account(500, "Bob", 3000));
        accounts.add(new Account(300, "David", 2000));

        System.out.println("\n****** Sorting by balance ******");
        Collections.sort(accounts);

        for (Account account : accounts) {
            System.out.println(account.getDetails());
        }

        System.out.println("\n****** Sorting by owner ******");
        Collections.sort(accounts, new SortByOwner());
        for (Account account : accounts) {
            System.out.println(account.getDetails());
        }

        Account.makeDouble(100);
    }
}
