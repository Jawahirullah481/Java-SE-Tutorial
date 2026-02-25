package multithreading;

import multithreading.handler.ThreadHandler;

import java.util.LinkedList;
import java.util.Queue;

public class Class8WaitNotify extends ThreadHandler {

    /*
    ====================================================
            WAIT() / NOTIFY() PRACTICE
            PRODUCER CONSUMER PROBLEM
    ====================================================

    Producer  -> Produces transactions
    Consumer  -> Processes transactions

    wait()
    ------
    Releases object lock and moves thread
    to waiting state.

    notify()
    --------
    Wakes one waiting thread.

    Rules:
    - Must be called inside synchronized block
    - Works on object monitor(lock)
    ====================================================
    */

    static class TransactionQueue {

        private final Queue<Integer> queue = new LinkedList<>();
        private final int LIMIT = 5;

        // PRODUCER
        public synchronized void produce(int value)
                throws InterruptedException {

            // wait if queue is full
            while (queue.size() == LIMIT) {
                System.out.println("Queue Full... Producer waiting");
                wait();
            }

            queue.add(value);
            System.out.println("Produced : " + value);

            // notify consumer
            notify();
        }

        // CONSUMER
        public synchronized void consume()
                throws InterruptedException {

            // wait if queue empty
            while (queue.isEmpty()) {
                System.out.println("Queue Empty... Consumer waiting");
                wait();
            }

            int value = queue.poll();
            System.out.println("Consumed : " + value);

            // notify producer
            notify();
        }
    }

    @Override
    public void execute() {

        TransactionQueue queue = new TransactionQueue();

        // Producer Thread
        Thread producer = new Thread(() -> {
            int value = 1;
            while (true) {
                try {
                    queue.produce(value++);
                    Thread.sleep(500);
                } catch (Exception e) {}
            }
        });

        // Consumer Thread
        Thread consumer = new Thread(() -> {
            while (true) {
                try {
                    queue.consume();
                    Thread.sleep(1000);
                } catch (Exception e) {}
            }
        });

        producer.start();
        consumer.start();
    }
}
