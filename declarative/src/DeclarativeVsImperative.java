import java.util.List;

import static java.lang.System.out;

public class DeclarativeVsImperative {

    public static void main(String[] args) {

        List<Integer> numbers = List.of(18, 6, 4, 15, 55, 78, 12, 9, 8, 123, 78, 91, 37, 85, 87, 134, 107, 57, 5, 1, 89, 255, 7, 88, 200, 123, 66);

        // Imperative
        int accumulator = 0;
        for (int number : numbers) {
            if (number % 2 != 0) {
                accumulator += number * number;
            }
        }
        out.println(accumulator);


        // Declarative
        Integer result = numbers.stream().filter(num -> num % 2 != 0).mapToInt(num -> num * num).sum();
        out.println(result);
    }
}


// Given a certain list of integers, return the sum of the squares for the odd numbers.
// Dada una lista de entero, devolver la suma de los cuadrados de los números impares.