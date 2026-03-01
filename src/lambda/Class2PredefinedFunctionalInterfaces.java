package lambda;

import lambda.handler.LambdaHandler;

import java.util.function.*;

public class Class2PredefinedFunctionalInterfaces extends LambdaHandler {

    @Override
    public void execute() {

        // 1. Predicate : Takes 1 Argument and returns boolean
        Predicate<Integer> predicate = (age) -> age >= 18;

        // 2. Function : Takes 1 Argument and returns a Value
        Function<Integer, String> function = (dayOfWeek) -> {
            String day;
            switch (dayOfWeek) {
                case 1 : day = "Monday"; break;
                case 2 : day = "Tuesday"; break;
                case 3 : day = "Wednesday"; break;
                case 4 : day = "Thursday"; break;
                case 5 : day = "Friday"; break;
                case 6 : day = "Saturday"; break;
                case 7 : day = "Sunday"; break;
                default: day = "Invalid Day"; break;
            }

            return day;
        };

        // 3. Consumer : Takes 1 Value and doesn't return anything
        Consumer<Integer> consumer = (value) -> { System.out.println("The Entered Value is : " + value); };

        // 4. Supplier : Doesn't take any argument and returns a value
        Supplier<Integer> supplier = () -> { return (int)(Math.random() * 10) + 1;};

        BiPredicate<String, String> biPredicate = (a, b) -> a.equalsIgnoreCase(b);

        BiFunction<Double, Double, Double> biFunction = (a, b) -> a + b;

        BiConsumer<Integer, Integer> biConsumer = (a, b) -> { System.out.printf("The sum of %d and %d is : %d%n", a, b, a + b); };


        System.out.println("The Age 15 is " + (predicate.test(15) ? "Valid" : "Invalid"));
        System.out.println("The 5th Day of Week is " + function.apply(5));
        consumer.accept(3);
        System.out.println("The Lucky Number is " + supplier.get());
        System.out.println("The Strings xyz and XyZ are same : " + biPredicate.test("xyz", "XyZ"));
        System.out.printf("The Sum of 1.2 and 2.4 is %.2f%n", biFunction.apply(1.2, 2.4));
        biConsumer.accept(10, 15);
    }
}
