package stream;

import stream.handler.StreamHandler;

import java.util.*;
import java.util.stream.Collectors;

public class Class4PracticePrograms extends StreamHandler {
    @Override
    public void execute() {

        List<Integer> list = List.of(1,2,3,4,5,3,2,1);

        // 1. Count Even Numbers
        long count = list.stream().filter(num -> num % 2 == 0).count();
        System.out.println("Number of Even Numbers : " + count);

        // 2. Find max
        int maxValue = list.stream().max(Integer::compare).orElse(0);
        System.out.println("Maximum Value : " + maxValue);

        // 3. Sum of Numbers
        int sum = list.stream().reduce(Integer::sum).orElse(0);
        System.out.println("Sum of Numbers : " + sum);

        // 4. Print First Matching element
        list.stream().filter(num -> num % 2 == 0).findFirst().ifPresent(num -> System.out.println("First Event Element : " + num));

        // 5. Find Duplicate Numbers
        Set<Integer> added = new HashSet<>();
        List<Integer> duplicates = list.stream().filter(num -> !added.add(num)).collect(Collectors.toList());
        System.out.println("Duplicate Numbers : " + duplicates);

        // 6. Frequency of Each Element
        Map<Integer, Long> itemsCount = list.stream().collect(Collectors.groupingBy(num -> num, Collectors.counting()));
        System.out.println("Frequency : " + itemsCount);

        // 7. Flatten Nested List
        List<List<Integer>> nestedList = List.of(
                List.of(1, 2),
                List.of(3, 4)
        );
        List<Integer> twoMultiples = nestedList.stream().flatMap(childList -> childList.stream()).map(num -> num * 2).collect(Collectors.toList());
        System.out.println("Tow Multiples : " + twoMultiples);

    }
}
