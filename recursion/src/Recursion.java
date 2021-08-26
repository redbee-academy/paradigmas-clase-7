import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

import static java.lang.System.out;

public class Recursion {

    public static void main(String[] args) {

        out.println(fibonacci(12));
    }

    private static List<Integer> fibonacci(Integer n) {

        List<Integer> list = new ArrayList<>();
        IntStream.range(0, n + 1).map(Recursion::_fibonacci).forEach(list::add);

        return list;
    }

    private static Integer _fibonacci(Integer n) {

        if (n == 0) {
            return 0;
        }

        if (n == 1) {
            return 1;
        }

        return _fibonacci(n - 1) + _fibonacci(n - 2);
    }
}
