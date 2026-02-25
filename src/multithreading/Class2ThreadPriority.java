package multithreading;

import multithreading.handler.ThreadHandler;

public class Class2ThreadPriority extends ThreadHandler {

    /*
        Compare Previous Program to this one to know how Thread Priority Works.
     */

    @Override
    public void execute() {

        Thread thread1 = new MyThread("Thread 1");
        Thread thread2 = new MyThread("Thread 2");

        thread1.setPriority(Thread.MIN_PRIORITY);
        thread2.setPriority(Thread.MAX_PRIORITY);

        thread1.start();
        thread2.start();
    }

    private class MyThread extends Thread {

        MyThread(String threadName) {
            super(threadName);
        }

        @Override
        public void run() {
            for (int i = 1; i <= 5; i++) {
                System.out.println(Thread.currentThread().getName() + " : " + i);
            }
        }

    }
}