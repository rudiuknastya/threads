package streams;

import java.util.*;
import java.util.Arrays;
import java.util.stream.*;

public class Example {
    public static void main(String[] args) {
        Stream<String> nameStream = Stream.of("Sam","Nick","Jack","Sandy","Kira","Anna","Britni","Jessica");
        //nameStream.filter();

        String[] arr = new String[]{"a", "b", "c"};
        Arrays.stream(arr);

        Stream<String> streamGenerated = Stream.generate(() -> "hi").limit(5);
        streamGenerated.forEach(System.out::println);

        IntStream intStream = IntStream.range(1, 6); // rangeClosed()

        List<Integer> numbers = new ArrayList<>();
        numbers.stream();

    }
}
