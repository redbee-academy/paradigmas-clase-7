import java.util.function.BiFunction;
import java.util.function.Function;

import static java.lang.System.out;

public class Currying {

    public static void main(String[] args) {

        BiFunction<Integer, Integer, Integer> sum = Integer::sum; // (a, b) -> a + b
        Function<Integer, Function<Integer, Integer>> sumCurried = a -> b -> a + b;

        Function<Integer, Integer> add3 = sumCurried.apply(3);

        Integer a1 = 6;
        Integer b2 = 7;

        out.println("Suma: (" + a1 + " + " + b2 + ") = " + sum.apply(a1, b2));

        out.println("Suma currificada: (" + a1 + " + " + b2 + ") = " + sumCurried.apply(a1).apply(b2));

        out.println("Suma de 3 parcialmente aplicada: (" + a1 + " + 3) = " + add3.apply(a1));
    }
}
