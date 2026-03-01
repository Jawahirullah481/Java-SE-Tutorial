package stream;

import stream.handler.StreamHandler;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Class3TerminatingStreams extends StreamHandler {

    @Override
    public void execute() {

        // 1. forEach()
        getStream().forEach(val -> System.out.print(val + " "));

        // 2. collect()
        List<Integer> filtered = getStream().filter(i -> i > 7).collect(Collectors.toList());
        System.out.println("Filtered : " + filtered);

        // 3. reduce()
        int multiplied = getStream().reduce(1, (a, b) -> a * b);
        System.out.println("Multiplied : " + multiplied);

        // 4. count()
        long count = getStream().count();
        System.out.println("Count : " + count);

        // 5. min() / max()
        Optional<Integer> min = getStream().min(new Comparator<Integer>() { // Traditional Anonymous class
            @Override
            public int compare(Integer o1, Integer o2) {
                return (o1 > o2) ? 1 : (o1 == o2) ? 0 : -1;
            }
        });

        Optional<Integer> max = getStream().min((o1, o2) -> { // Lambda Replacement for Comparator Implementation
            return -((o1 > o2) ? 1 : (o1 == o2) ? 0 : -1);
        });

        System.out.println("Min Value : " + (min.orElse(0)));
        System.out.println("Max Value : " + (max.orElse(0)));

        // 6. findFirst() / findAny()
        int first = getStream().filter(a -> a % 2 == 1).sorted().findFirst().orElse(-1);
        System.out.println("First Odd Number : " + first);

        // 7. anyMatch() / allMatch() / noneMatch()
        boolean anyMatch = getStream().anyMatch(num -> num == 3);
        boolean allMatch = getStream().allMatch(num -> num % 2 == 0);
        boolean noneMatch = getStream().noneMatch(num -> num > 10);

        System.out.println("Is 3 Present : " + anyMatch);
        System.out.println("Is All are Even : " + allMatch);
        System.out.println("Nothing is greater than 10 : " + noneMatch);

    }

    private Stream<Integer> getStream() {
        return Stream.of(5, 3, 7, 9, 10, 3, 2);
    }
}
