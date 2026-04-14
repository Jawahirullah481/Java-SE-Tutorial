package com.jawa.javacoretutorial;

import com.jawa.javacoretutorial.exceptionhandling.factory.ExceptionHandlingFactory;
import com.jawa.javacoretutorial.filehandling.factory.FileHandlingFactory;
import com.jawa.javacoretutorial.generics.factory.GenericsFactory;
import com.jawa.javacoretutorial.httprequests.factory.HttpFactory;
import com.jawa.javacoretutorial.lambda.factory.LambdaFactory;
import com.jawa.javacoretutorial.multithreading.factory.MultiThreadingFactory;
import com.jawa.javacoretutorial.stream.factory.StreamFactory;

public class Main {
    public static void main(String[] args) {

        // 1. Exception Handling
        ExceptionHandlingFactory.execute();

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
        // HttpFactory.execute();

    }
}