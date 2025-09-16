package lab06_01d_10b;

import java.util.Comparator;

public class SortByOwner implements Comparator<Account> {
    @Override
    public int compare(Account account1, Account account2) {
        return account1.owner.compareTo(account2.owner);
    }
}
