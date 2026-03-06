import filehandling.factory.FileHandlingFactory;
import generics.factory.GenericsFactory;
import httprequests.factory.HttpFactory;
import lambda.factory.LambdaFactory;
import multithreading.factory.MultiThreadingFactory;
import stream.factory.StreamFactory;

public class Main {
    public static void main(String[] args) {

        // 1. Exception Handling
        // ExceptionHandlingFactory.execute();

        // 2. Multi Threading
        // MultiThreadingFactory.execute();

        // 3. File Handling
        // FileHandlingFactory.execute();

        // 4. Generics
        // GenericsFactory.execute();

        // 5. Lambda Expression
        // LambdaFactory.execute();

        // 6. Stream
        // StreamFactory.execute();

        // 7. Http
        HttpFactory.execute();

    }
}