import java.util.List;
import java.util.function.Function;

import static java.lang.System.out;

public class Composition {


    private static final Function<String, Integer> length = String::length; // str -> str.length()
    private static final Function<Integer, String> asterisk = "*"::repeat; // n -> "*".repeat(n)

    private static final Function<String, String> hideName = asterisk.compose(length);
    private static final Function<String, String> hideName2 = length.andThen(asterisk);

    private static final Function<String, String> hideNameAManopla = name -> "*".repeat(name.length());

    public static void main(String[] args) {

        List<String> names = List.of("Agustina", "Aix", "Ana", "Andrea", "Celeste", "Cintia", "Florencia", "Indiana", "Joselina", "Leonela", "Lore", "Noelia", "Pia", "Priscila", "Rosa", "Ximena");

        names.stream()
                .map(hideName)
                //.map(hideName2)
                //.map(hideNameAManopla)
                .forEach(out::println);
    }
}
