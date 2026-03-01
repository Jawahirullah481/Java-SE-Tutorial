package stream;

import stream.handler.StreamHandler;

import java.util.Arrays;
import java.util.List;

public class Class2ProcessingStreams extends StreamHandler {

    @Override
    public void execute() {

        List<Integer> list = Arrays.asList(7, 1, 8, 4, 2, 1, 4);

        // 1. filter()
        list.stream().filter(i -> i % 2 == 0).forEach(System.out::println);

        // 2. map()
        list.stream().map(i -> i + 10).forEach(System.out::println);

        // 3. mapToInt(), mapToLong(), mapToDouble()
        list.stream().mapToInt(Integer::intValue).forEach(System.out::println);

        // 4. flatMap() : Used for nested collections
        List<List<String>> nestedLists = Arrays.asList(
                List.of("One", "Two", "Three"),
                List.of("Four", "Five", "Six")
        );

        nestedLists.stream().flatMap(List::stream).forEach(System.out::println);

        // 5. sorted()
        list.stream().sorted().forEach(System.out::println);

        // 6. distinct()
        list.stream().distinct().forEach(System.out::println);

        // 7. limit()
        list.stream().limit(3).forEach(System.out::println);

        // 8. skip()
        list.stream().skip(3).forEach(System.out::println);

    }
}
