import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Value;
import lombok.With;

@Value
@With
@AllArgsConstructor
public class Ship {
    String color;
    String model;
    String brand;
    LocalDate year;
}
