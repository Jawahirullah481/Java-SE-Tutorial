package exceptionhandling;

import exceptionhandling.handler.ExceptionHandler;

public class Class3ReturnVsFinally extends ExceptionHandler {

    /*
        Even though return statement present in try or catch blocks first finally will be executed and after that only return statement will be considered.
        That is , finally block dominates return statement.
     */

    @Override
    public void run() {

        System.out.println("Returned Value is : " + returnVsFinally());

    }

    private int returnVsFinally() {
        try {
            System.out.println(10 / 0);
            return 777;
        } catch (ArithmeticException e) {
            return 888;
        } finally {
            return 999;
        }
    }
}
