package multithreading;

import multithreading.handler.ThreadHandler;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Class10ThreadPool extends ThreadHandler {

    @Override
    public void execute() {

        ExecutorService service = Executors.newFixedThreadPool(3);

        for (int i = 1; i <= 5; i++) {
            service.submit(() -> {
                System.out.println(
                        "Hello World! " +
                                Thread.currentThread().getName()
                );
            });
        }

        service.shutdown();

    }

}
