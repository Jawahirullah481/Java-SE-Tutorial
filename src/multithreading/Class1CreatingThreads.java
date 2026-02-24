package multithreading;

import multithreading.handler.ThreadHandler;

public class Class1CreatingThreads extends ThreadHandler {

    @Override
    public void execute() {
        // Method 1 : Extending Thread Class
        Thread thread1 = createThread1();

        // Method 2 : Implementing Runnable
        Thread thread2 = createThread2();

        thread1.start();
        thread2.start();
    }

    private Thread createThread1() {
        Thread thread1 = new MyThread();
        return thread1;
    }

    private Thread createThread2() {
        Thread thread2 = new Thread(new MyRunnable());
        return thread2;
    }

    private class MyThread extends Thread {

        @Override
        public void run() {
            for (int i = 1; i <= 5; i++) {
                try {

                    System.out.println("Thread 1 : " + i);
                    Thread.sleep(1000);

                } catch (InterruptedException e) {}
            }
        }

    }

    private class MyRunnable implements Runnable {

        @Override
        public void run() {
            for (int i = 1; i <= 5; i++) {
                try {

                    System.out.println("Thread 2 : " + i);
                    Thread.sleep(1000);

                } catch (InterruptedException e) {}
            }
        }
    }
}
