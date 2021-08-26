import lombok.AllArgsConstructor;
import lombok.Value;
import lombok.With;

@Value
@AllArgsConstructor
public class Money {
    @With
    Double amount;
    String type;
}
