import lombok.Value;

@Value
public class Transaction {
    Account from;
    Account to;
    Money money;
}
