import lombok.SneakyThrows;

import static java.lang.System.identityHashCode;
import static java.lang.System.out;
import static java.lang.Thread.sleep;
import static java.time.LocalDate.ofYearDay;
import static java.util.stream.IntStream.range;

public class Mutability {

    private static Car car = new Car("WHITE", "Sedan", "Volkswagen", ofYearDay(2021, 1), 0, 100, false);

    public static void main(String[] args) {

        Runnable race = Mutability::race;
        race.run();

        // Let's go for a little car ride...

        // Let's get ready...
        prepareTheRide();

        // And now, the ride...
        range(1, 6).forEach((round) -> {
            out.println("This is round No. " + round + " of " + car + " [" + identityHashCode(car) + "]");
            car.incrementKms();
        });
    }

    @SneakyThrows
    private static void prepareTheRide() {

        sleep(1000);
        out.println("The staff for the ride is ready!!!");
    }

    @SneakyThrows
    private static void race() {

        out.println("Preparing for the race...");
        sleep(55);

        out.println("The " + car + " [" + identityHashCode(car) + "] is running...");
        range(0, 90).forEach(__ -> car.incrementKms());
    }
}
