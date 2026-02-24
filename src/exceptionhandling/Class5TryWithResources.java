package exceptionhandling;

import exceptionhandling.handler.ExceptionHandler;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Class5TryWithResources extends ExceptionHandler {

    /*
        # Try-with-resources is used to automatically close resources after use.
        # It was introduced in Java 7 to simplify resource management and avoid memory leaks.
        # No need to explicitly close the opened resources in finally block, as try with resources automatically do it
        # The Class must be AutoCloseable then only we can use it with try with resources.
     */

    @Override
    public void run() {
        try(BufferedReader reader = new BufferedReader(new FileReader("resources/TestFile.txt"))) {
            System.out.println(reader.readLine());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
}
