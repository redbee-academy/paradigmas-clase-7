import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Car {

    private String color;
    private String model;
    private String brand;
    private LocalDate year;
    private Integer kilometers;
    private Integer kmsService = 10;
    private Boolean service;

    public void incrementKms() {

        kilometers = kilometers + 1;
        if (kilometers >= kmsService) {
            service = true;
        }
    }
}
