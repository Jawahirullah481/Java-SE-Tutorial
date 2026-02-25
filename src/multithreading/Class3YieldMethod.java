package multithreading;

import multithreading.handler.ThreadHandler;

public class Class3YieldMethod extends ThreadHandler {

    /*
        yield() : (Giving Chance)

        Thread.yield() is a static method that hints the thread scheduler to temporarily pause the current thread
        and allow other runnable threads of the same priority to execute.
     */

    @Override
    public void execute() {

        Thread t1 = new Thread(new Runnable() {

            @Override
            public void run() {
                for(int i = 0; i <= 5; i++) {
                    System.out.println("Thread 1 : " + i);
                }
            }

        });

        Thread t2 = new Thread(new Runnable() {

            @Override
            public void run() {
                for(int i = 0; i <= 15; i++) {
                    System.out.println("Thread 2 : " + i);
                }
            }

        });

        Thread t3 = new Thread(new Runnable() {

            @Override
            public void run() {
                for(int i = 0; i <= 5; i++) {
                    if(i == 3) {
                        Thread.yield();
                    }
                    System.out.println("Thread 3 : " + i);
                }
            }

        });

        t1.setPriority(Thread.MIN_PRIORITY);
        t2.setPriority(Thread.NORM_PRIORITY);
        t3.setPriority(Thread.NORM_PRIORITY);

        t1.start();
        t2.start();
        t3.start();

    }

}
