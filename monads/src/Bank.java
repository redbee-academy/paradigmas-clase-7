import java.util.List;
import java.util.Optional;

public class Bank {

    List<Account> accounts;

    public Bank(List<Account> accounts) {
        this.accounts = accounts;
    }

    public Account findAccount(Integer accountNumber) {

        Account acc = null;
        for (Account account:accounts) {
            if(account.getNumber().equals(accountNumber)) {
                acc = account;
                break;
            }
        }

        return acc;
    }


    public Optional<Account> findAccountSafe(Integer accountNumber) {

        return accounts.stream()
                .filter(account -> account.getNumber().equals(accountNumber))
                .findFirst();
    }

    public Transaction transaction(Account from, Account to, Money money) {
        return new Transaction(from, to, money);
    }

    public Account withdraw(Account account, Money money) {

        return account.withBalance(account.subtract(money));
    }
}
