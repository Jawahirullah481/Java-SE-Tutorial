package lambda;

import lambda.handler.LambdaHandler;

import java.util.stream.Stream;

public class Class1SimpleLambda extends LambdaHandler {

    /*
        When we are using streams api, we need to write code for one time.

        For that 1 time, it is unnecessary to create a separate class or anonymous class and override the method and so on.
        So, to make it easier, lambda expressions are very introduced.
     */

    @Override
    public void execute() {
        Calculator calc = (a, b) -> a + b;
        System.out.println(calc.sum(5, 6));
    }

    @FunctionalInterface
    interface Calculator {
        int sum(int a, int b);
    }

}
