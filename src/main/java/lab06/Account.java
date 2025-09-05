package lab06;

public class Account {
    private int id;
    private double balance;
    private String owner;

    public Account(int id, double balance, String owner) {
        this.id = id;
        this.balance = balance;
        this.owner = owner;
    }

    public void withraw(double amount) {
        if (balance - amount < 0) {
            throw new IllegalArgumentException("Your balance is not enough to withraw");
        }
        balance -= amount;
    }

    public void deposit(double amount) {
        balance += amount;
    }

    public void close() {
        System.out.printf("Account %d is closed.", id);
    }

    public String getDetails() {
        return String.format("Account %d for %s has %.2f balance.", id, owner, balance);
    }
}
