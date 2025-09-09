package lab06;

public class Account implements Comparable<Account> {
    private int id;
    protected String owner;
    private double balance;

    public Account(int id, String owner, double balance) {
        this.id = id;
        this.owner = owner;
        this.balance = balance;
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
        System.out.printf("Account %d is closed.\n", id);
    }

    public String getDetails() {
        return String.format("Account %d for %s has %.2f balance.", id, owner, balance);
    }

    @Override
    public int compareTo(Account account) {

        return (int) (this.balance - account.balance);
    }
}
