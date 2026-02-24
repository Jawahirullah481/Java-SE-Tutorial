package exceptionhandling;

import exceptionhandling.handler.ExceptionHandler;

public class Class2HandlineMultipleExceptions extends ExceptionHandler {

    @Override
    public void run() {
        try {
            int a = Integer.parseInt("One");
        } catch (ArithmeticException e) {
            System.out.println("This is an Arithmetic Exception");
        } catch (NullPointerException e) {
            System.out.println("This is a NullPointer Exceptino");
        } catch (NumberFormatException e) {
            System.out.println("This is a Number Format Exception");
        } catch (Exception e) {
            System.out.println("No above exceptions matched!");
        }
    }

}
