import lombok.SneakyThrows;

import java.time.LocalDate;

import static java.lang.System.identityHashCode;
import static java.lang.System.out;
import static java.lang.Thread.sleep;
import static java.time.LocalDate.now;
import static java.time.LocalDate.ofYearDay;
import static java.util.stream.IntStream.range;

public class Immutability {

    public static void main(String[] args) {

        Ship ship = new Ship("Azul", "Pesca", "Colon", now());
        Ship newShip = ship.withColor("Blanco");

        System.out.println(ship);
        System.out.println(newShip);
    }
}
