package lambda;

import lambda.handler.LambdaHandler;

import java.util.ArrayList;
import java.util.function.*;

public class Class3MethodReference extends LambdaHandler {

    /*
        1. When to use Method Reference ?

        Method Reference Always used instead of single statement lambda expression. Without this only schenario, we can't use method reference.


        2. Is there any rules ?

        By writing lambda expression, what we are actually doing is,

        # we are creating the anonymous class of the functional interface and providing implementation of that method.
        # By using method reference in place of lambda expression, what will happen is, inside that implementation of that anymous class' function, our method reference call will happen.
        # So, the number of arguments and return type should match the functional interface's method and our method reference's method.

        Example :

        1. Lambda Code :
        ============
        Consumer<String> c = (param) -> System.out.println(param);


        2. Method Reference :
        ==================
        Consumer<String> c = System.out::println;


        3. Internal Conversion of both :
        ===============================

        Consumer<String> c = new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println(s); // Whatever code we write in Lambda or Method reference, will go inside this.
            }
        };

     */

    @Override
    public void execute() {

        // 1.
        Predicate<String> predicate = String::isEmpty;

        // 2.
        BiPredicate<String, String> biPredicate = String::equalsIgnoreCase;

        // 3.
        Function<Double, Double> function = Math::ceil;

        // 4.
        BiFunction<Double, Double, Double> biFunction = Math::pow;

        // 5.
        Consumer<String> consumer = System.out::println;

        // 6. Currently, there is no predefined functions available
        BiConsumer<String, String> biConsumer = this::mergeStrings;

        // 7.
        Supplier<ArrayList<Double>> supplier = ArrayList<Double>::new;

    }

    public void mergeStrings(String s1, String s2) {
        String s3 = s1 + s2;
    }

}
