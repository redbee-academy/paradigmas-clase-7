import lombok.AllArgsConstructor;
import lombok.Value;
import lombok.With;

import java.time.LocalDate;

@Value
@With
@AllArgsConstructor
public class ImmutableCar {

    String color;
    String model;
    String brand;
    LocalDate year;
    Integer kilometers;
    Integer kmsService = 10;
    Boolean service;

    public static ImmutableCar incrementKms(ImmutableCar oldCar) {

        ImmutableCar newCar = oldCar.withKilometers(oldCar.kilometers + 1);
        if (newCar.kilometers >= newCar.kmsService) {
            return newCar.withService(true);
        }

        return newCar;
    }
}
