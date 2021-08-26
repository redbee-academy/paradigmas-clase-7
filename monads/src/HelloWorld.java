import java.util.List;
import java.util.Optional;

import static java.lang.System.out;

public class HelloWorld {

    public static void main(String[] args) {

        //Monadas

        Account acc1 = new Account(1, AccountType.CC, new Money(100.00, "Pesos"));
        Account acc2 = new Account(2, AccountType.CA, new Money(100.00, "Pesos"));
        Account acc3 = new Account(3, AccountType.CA, new Money(100.00, "Pesos"));
        Account acc4 = new Account(4, AccountType.CA, new Money(100.00, "Pesos"));
        Account acc5 = new Account(5, AccountType.CA, new Money(100.00, "Pesos"));
        Account acc6 = new Account(6, AccountType.CA, new Money(100.00, "Pesos"));
        Account acc7 = new Account(7, AccountType.CA, new Money(100.00, "Pesos"));
        Account acc8 = new Account(8, AccountType.CA, new Money(100.00, "Pesos"));
        Account acc9 = new Account(9, AccountType.CA, new Money(100.00, "Pesos"));

        List<Account> accounts = List.of(acc1, acc2, acc3, acc4, acc5, acc6, acc7, acc8, acc9);

        Bank bank = new Bank(accounts);

        Account account1 = bank.findAccount(1);
        out.println(account1);

        account1 = bank.findAccount(30);
        if (account1 != null) {
            out.println(account1);
        }

        Optional<Account> account2 = bank.findAccountSafe(1);
        out.println(account2.isPresent() ? account2.get() : "No account found...");

        account2 = bank.findAccountSafe(30);
        account2.ifPresentOrElse(account -> out.println("" + account), () -> out.println("No account found for accountNumber: " + 30));

        Optional<Account> from = bank.findAccountSafe(1);
        Optional<Account> to = bank.findAccountSafe(2);
        Money money = new Money(10.0, "Pesos");

        //bank.transaction(from, to, money);

        Optional<Account> account3 =
                from
                        .map(account -> bank.withdraw(account, money))
                        .map(account -> bank.withdraw(account, money))
                        .map(account -> bank.withdraw(account, money));
        account3.ifPresent(val -> out.println("account3 = " + val));

//        Account account4 = to.get();
//        account4 = bank.withdraw(bank.withdraw(bank.withdraw(account4, money), money), money);
//        out.println(account4);

        Optional<Account> account5 = bank.findAccountSafe(30);
        Optional<Account> account6 = account5
                .map(account -> bank.withdraw(account, money))
                .map(account -> bank.withdraw(account, money));
        account6.ifPresentOrElse(account -> out.println("account5 = " + account), () -> out.println("No account found for accountNumber: " + 30));
//
//        bank.withdraw(from.get(), money);
//
//        Optional<Transaction> transaction = from.flatMap(f -> to.map(t -> bank.transaction(f, t, money)));

    }
}
