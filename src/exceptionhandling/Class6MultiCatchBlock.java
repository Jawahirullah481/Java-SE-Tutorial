package exceptionhandling;

import exceptionhandling.handler.ExceptionHandler;

public class Class6MultiCatchBlock extends ExceptionHandler {

    @Override
    public void run() {

        try {
            Double a = Double.parseDouble("13.h");
        } catch (NullPointerException | ArithmeticException | NumberFormatException e) {
            e.printStackTrace();
        }

    }
}
