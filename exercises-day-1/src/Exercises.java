import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

import static java.lang.System.out;
import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.summingDouble;

public class Exercises {

    public static void main(String[] args) {

        // Exercises

        // Arithmetic functions

//        BiFunction<Integer, Integer, Integer> suma = (a,b) -> a + b;
//        BiFunction<Integer, Integer, Integer> resta = (a,b) -> a - b;
//        BiFunction<Integer, Integer, Integer> multiplicacion = (a,b) -> a * b;
//        BiFunction<Integer, Integer, Integer> div = (a,b) -> a / b;
//
//        suma.apply(1,2);
//        resta.apply(3,2);
//        multiplicacion.apply(2,2);
//        div.apply(5,2);


        // Packages
        Package package1 = new Package(1, "direccion", "localidad1", 10.0);
        Package package2 = new Package(2, "direccion", "localidad2", 20.0);
        Package package3 = new Package(3, "direccion", "localidad1", 30.0);
        Package package4 = new Package(4, "direccion", "localidad2", 40.0);
        Package package5 = new Package(5, "direccion", "localidad1", 50.0);
        Package package6 = new Package(6, "direccion", "localidad2", 60.0);
        Package package7 = new Package(7, "direccion", "localidad1", 70.0);
        Package package8 = new Package(8, "direccion", "localidad2", 80.0);
        Package package9 = new Package(9, "direccion", "localidad1", 90.0);

        List<Package> packages = List.of(package1, package2, package3, package4, package5, package6, package7, package8, package9);

        Function<String, Long> packagesByCity = city -> packages.stream()
                .filter(pkg -> city.equals(pkg.getCity()))
                .count();

        Function<String, Double> weightPerShipment = city -> (Double) packages.stream()
                .filter(pkg -> city.equals(pkg.getCity()))
                .mapToDouble(Package::getWeight) // pkg -> pkg.getWeight()
                .sum();

        String city = "localidad1";
        out.println(packagesByCity.apply(city) + " packages para " + city);

        city = "localidad2";
        out.println(weightPerShipment.apply(city) + "ks de peso para el embarque para " + city);

        Map<String, Double> shipmentsWeight = packages.stream()
                .collect(groupingBy(Package::getCity, summingDouble(Package::getWeight)));

        shipmentsWeight.forEach((k, v) -> out.println(v + "ks de peso para el embarque para " + k));

        out.println(shipmentsWeight);
    }
}
