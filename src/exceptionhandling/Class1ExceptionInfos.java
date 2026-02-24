package exceptionhandling;

public class Class1ExceptionInfos extends ExceptionHandler {

    /*
        Exception Object contains following 3 informations
            # Exception Type
            # Exception Cause
            # Place where Exception Occurred
     */

    @Override
    public void run() {

        try {

            int a = 5 / 0;

        } catch (ArithmeticException e) {
            e.printStackTrace();
        }

    }
}
