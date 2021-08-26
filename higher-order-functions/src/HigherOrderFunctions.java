import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.OptionalDouble;
import java.util.function.Function;
import java.util.stream.Collectors;

import static java.lang.System.out;
import static java.util.stream.Collectors.*;

public class HigherOrderFunctions {

    private static final Function<String, Integer> length = String::length; // str -> str.length()
    private static final Function<Integer, String> asterisk = "*"::repeat; // n -> "*".repeat(n)

    private static final Function<String, String> hideName = asterisk.compose(length);

    public static void main(String[] args) {

        List<String> names = List.of("Agustina", "Aix", "Ana", "Andrea", "Celeste", "Cintia", "Florencia", "Indiana", "Joselina", "Leonela", "Lore", "Noelia", "Pia", "Priscila", "Rosa", "Ximena");

        String allTogether = names.stream()
                .map(String::toLowerCase) // name -> name.toLowerCase()
                .reduce("", (str, name) -> str + "_" + name);
        out.println(allTogether);

        allTogether = names.stream()
                .map(String::toLowerCase) // name -> name.toLowerCase()
                .collect(joining("_"));
        out.println(allTogether);

        Integer total = names.stream()
                .map(length) //name -> name.length()
                .mapToInt(i -> i)
                //.reduce(0, (acc, lng) -> acc + lng);
                .sum();
        out.println(total);

        OptionalDouble total3 = names.stream()
                .map(length) // name -> name.length()
                .mapToDouble(i -> i)
                //.reduce(0, (acc, lng) -> acc + lng);
                .average();
        total3.ifPresent(out::println);

        Integer total2 = names.stream()
                .map(length) // name -> name.length()
                .reduce(1, (acc, lng) -> acc * lng);
        out.println(total2);

        out.println("Nombres que comienzan con 'A': " + names.stream().filter(name -> name.startsWith("A")).collect(toList()));

        out.println("Separadas por letra del nombre: " + names.stream().collect(groupingBy(name -> name.substring(0, 1))));
    }
}
