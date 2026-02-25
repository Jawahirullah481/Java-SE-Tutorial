package multithreading;

import multithreading.handler.ThreadHandler;

public class Class5InterruptMethod extends ThreadHandler {

    /*
        interrupt() : interrupt the particular thread.

        interrupt() will interrupt the thread only when the thread is going to sleep or waiting state.
        If the thread is in Ready or Running state, then it will not make effect.
     */

    @Override
    public void execute() {

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    for(int i = 1; i <= 5; i++) {
                        System.out.println("Child Thread : " + i);
                        Thread.sleep(1500);
                    }
                } catch (InterruptedException e) {
                    System.out.println("Child Thread Interrupted");
                }
            }
        });

        t1.start();

        try {
            for(int i = 1; i <= 5; i++) {
                if(i == 3) t1.interrupt();

                System.out.println("Main Thread : " + i);
                Thread.sleep(1500);
            }
        } catch (InterruptedException e) {  }

    }

}
