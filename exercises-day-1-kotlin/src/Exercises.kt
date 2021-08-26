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
val package1 = Package(1, "direccion", "localidad1", 10.0)
val package2 = Package(2, "direccion", "localidad2", 20.0)
val package3 = Package(3, "direccion", "localidad1", 30.0)
val package4 = Package(4, "direccion", "localidad2", 40.0)
val package5 = Package(5, "direccion", "localidad1", 50.0)
val package6 = Package(6, "direccion", "localidad2", 60.0)
val package7 = Package(7, "direccion", "localidad1", 70.0)
val package8 = Package(8, "direccion", "localidad2", 80.0)
val package9 = Package(9, "direccion", "localidad1", 90.0)

val packages = listOf(package1, package2, package3, package4, package5, package6, package7, package8, package9)

fun packagesByCity(city: String) =
        packages.count { pkg: Package -> city == pkg.city }

fun weightPerShipment(city: String) =
        packages.filter { pkg -> city == pkg.city }.sumOf { obj: Package -> obj.weight }


fun main() {

    var city = "localidad1"
    println("${packagesByCity(city)}  packages para $city")

    city = "localidad2"
    println("${weightPerShipment(city)} ks de peso para el embarque para $city")

    val shipmentsWeight = packages
            .groupBy(Package::city) // Map<String, List<Packages>>
            .mapValues { it.value.sumOf(Package::weight) } // it.value = List<Packages>

    shipmentsWeight.forEach { (k, v) ->
        println("$v ks de peso para el embarque para $k")
    }
}
