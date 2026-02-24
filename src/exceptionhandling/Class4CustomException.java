package exceptionhandling;

import exceptionhandling.handler.ExceptionHandler;

public class Class4CustomException extends ExceptionHandler {

    @Override
    public void run() {
        payAmount(-500);
    }

    private void payAmount(double amount) {
        if(amount < 0) {
            throw new InvalidAmountException("Amount Cannot be Negative");
        }
    }
}
