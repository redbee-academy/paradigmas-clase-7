import lombok.Value;
import lombok.With;

import java.util.HashMap;
import java.util.function.Function;

@Value
@With
public class Account {

    Integer number;
    AccountType type;
    Money balance;

    HashMap<AccountType, Function<Money, Money>> subtractStrategy = new HashMap<>();

    public Account(Integer number, AccountType type, Money balance) {
        this.number = number;
        this.type = type;
        this.balance = balance;
        subtractStrategy.put(AccountType.CA, this::subtractCA);
        subtractStrategy.put(AccountType.CC, this::subtractCC);
    }

    public Money subtract(Money money) {
        return subtractStrategy.get(type).apply(money);
    }

    private Money subtractCA(Money money) {

        if (money.getAmount() > balance.getAmount() || moneyIsNotTheSameType(money)) {
            throw new RuntimeException();
        }

        return balance.withAmount(balance.getAmount() - money.getAmount());
    }

    private Money subtractCC(Money money) {

        if (moneyIsNotTheSameType(money)) {
            throw new RuntimeException();
        }

        return balance.withAmount(balance.getAmount() - money.getAmount());
    }

    private Boolean moneyIsNotTheSameType(Money money) {
        return !balance.getType().equals(money.getType());
    }

    public Money add(Money money) {
        return new Money(balance.getAmount() + money.getAmount(), balance.getType());
    }
}
