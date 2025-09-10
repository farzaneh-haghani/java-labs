package lab06;

public class SortByOwner extends Account {
    public SortByOwner(int id, String owner, Double balance) {
        super(id, owner, balance);
    }

    @Override
    public int compareTo(Account account) {
        return this.owner.compareTo(account.owner);

    }
}
