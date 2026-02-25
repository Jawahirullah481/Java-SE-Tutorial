package multithreading;

import multithreading.handler.ThreadHandler;

public class Class9DaemonThreads extends ThreadHandler {

    /*
        Daemon Threads are helper Threads to Main threads (Non Daemon Threads).
        When Non-Daemon Threads terminate, JVM automatically terminate Daemon Threads.

        Example : Garbage Collector
     */

    @Override
    public void execute() {

        Thread child = new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i = 1; i <= 5; i++) {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    System.out.println("Child Thread : " + i);
                }
            }
        });

        child.setDaemon(true);
        child.start();

        for(int i = 1; i <= 5; i++) {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("Parent Thread : " + i);
        }
    }
}
