import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.function.Function;

import static java.lang.System.out;

public class HelloFunctional {

    public static void main(String[] args) {

//        String hola = "hola";
//        Function<String, Integer> length = str -> str.length();
//
//        List<String> lista = List.of("hola", "hello", "ni hao", "konichiwa");
//        out.println(lista.stream().mapToInt(str -> str.length()).sum());

        // Pure Functions
        // Total
        Integer res = divide(8, 4);
        out.println("8 / 4 = " + res);

        //res = divide(5, 0);
        Optional<Integer> result = divideTotal(5, 0);
        result.ifPresent(out::println);

        result = divideTotal(8, 4);
        result.ifPresent(value -> out.println("8 / 4 = " + value));


        // Deterministic
//        Integer r1 = randomInteger();
//        out.println(r1);
//
//        Integer r2 = randomInteger();
//        out.println(r2);
//
//        Integer r3 = randomInteger(10);
//        out.println(r3);
//
//        Integer r4 = randomInteger(10);
//        out.println(r4);
    }

    public Integer length(String str) {
        return str.length();
    }

    private static Integer divide(Integer a, Integer b) {
        return a / b;
    }

    private static Optional<Integer> divideTotal(Integer a, Integer b) {

        if (b != 0) {
            return Optional.of(a / b);
        } else {
            return Optional.empty();
        }
    }

    private static Integer randomInteger() {

        Random generator = new Random();
        return generator.nextInt();
    }

    private static Integer randomInteger(Integer seed) {

        Random generator = new Random(seed);
        return generator.nextInt();
    }
}
