package multithreading;

import multithreading.handler.ThreadHandler;

public class Class4JoinMethod extends ThreadHandler {

    /*
        join() : Waiting for particular Thread.

        Comment the Join Call to know how the join works.
     */

    @Override
    public void execute() {

        Thread t1 = new AccountVerifier();
        Thread t2 = new AmountDeducter(t1);
        Thread t3 = new ConfirmationSender(t2);

        t3.start();
        t2.start();
        t1.start();

    }

    class AccountVerifier extends Thread {
        @Override
        public void run() {
            System.out.println("Account Verified");
        }
    }

    class AmountDeducter extends Thread {
        private Thread accountVerifierThread;

        AmountDeducter(Thread accountVerifierThread) {
            super();
            this.accountVerifierThread = accountVerifierThread;
        }

        @Override
        public void run() {
            try {
                this.accountVerifierThread.join();
            } catch (InterruptedException e) {  }

            System.out.println("Amount Deducted");
        }
    }

    class ConfirmationSender extends Thread {
        private Thread amountDeducterThread;

        ConfirmationSender(Thread amountDeducterThread) {
            super();
            this.amountDeducterThread = amountDeducterThread;
        }

        @Override
        public void run() {
            try {
                this.amountDeducterThread.join();
            } catch (InterruptedException e) {  }

            System.out.println("Confirmation Sent");
        }
    }
}
