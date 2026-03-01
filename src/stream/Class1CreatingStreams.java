package stream;

import stream.handler.StreamHandler;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Class1CreatingStreams extends StreamHandler {

    /*
        Important Note :
        ================

        Most important rule of the Stream API:

        ** A Stream can only be operated upon once. **
        In Java terms, a Stream has a lifecycle. Once a terminal operation (like forEach, collect, or reduce) is called, the stream is considered consumed and is closed.

        The Error: IllegalStateException
        When you run that second s.forEach(...), Java will throw: java.lang.IllegalStateException: stream has already been operated upon or closed
     */

    @Override
    public void execute() {

        // 1. Collection.stream() : From the Collection
        List<Integer> list = Arrays.asList(1, 2, 3, 4);
        list.stream().forEach(System.out::println);

        // 2. Arrays.stream() : From the Array
        String[] arr = {"One", "Two", "Three", "Four"};
        Arrays.stream(arr).forEach(System.out::println);

        // 3. Stream.of() : Static creation
        Stream<Character> staticStream = Stream.of('x', 'y', 'z');
        staticStream.forEach(System.out::println);

        // 4. Stream.empty() : Empty Stream Creation
        Stream<Integer> emptyStream = Stream.empty();

        // 5. Stream.generate() : Stream of Infinite Items (Note : Without limit, the stream becomes an infinite loop that prints "Hello" continuously, causing the executing thread to hang indefinitely without an immediate crash, as elements are processed one-by-one rather than stored in memory.)
        Stream<String> genStream = Stream.generate(() -> "I am Supplier").limit(5);
        genStream.forEach(System.out::println);

        // 6. Stream.iterate() : Create Stream and fill it with the values using iteration
        Stream<Integer> itrStream = Stream.iterate(2, n -> n + 2).limit(5);
        itrStream.forEach(System.out::println);

        // 7. range() from IntStream, LongStream, DoubleStream : Create numeric streams within range
        IntStream.range(11, 16).forEach(System.out::println);

    }
}
