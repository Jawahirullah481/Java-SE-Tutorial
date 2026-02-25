package multithreading;

import multithreading.handler.ThreadHandler;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Class7SynchronizedBlock extends ThreadHandler {
    /*
        ============================================================
                        SYNCHRONIZATION NOTES
        ============================================================

        Problem Without Synchronization
        -------------------------------
        When multiple threads access and modify a shared variable,
        unexpected results may occur.

        Example shared resource:
            balance

        Each update operation internally performs:

            1. Read balance
            2. Modify value
            3. Write updated value back

        This is called:
                READ → MODIFY → WRITE

        This operation is NOT atomic.


        Race Condition
        --------------
        If two threads execute simultaneously:

        Initial Balance = 500

        Thread-1 (Credit 100)
            Reads balance -> 500

        Thread-2 (Debit 200)
            Reads balance -> 500   (old value)

        Thread-1 writes -> 600
        Thread-2 writes -> 300

        Final balance becomes 300 (WRONG)

        Correct balance should be:
            500 + 100 - 200 = 400

        This problem is called:
                RACE CONDITION

        Meaning:
        One thread overrides the changes made by another thread.


        Role of Synchronization
        -----------------------
        'synchronized' ensures that only ONE thread can access
        a critical section at a time.

        When a thread enters a synchronized method:
            ✔ Object lock is acquired
            ✔ Other threads must wait
            ✔ Lock released after execution


        Example:
            synchronized void credit(double amount)

        Lock applied on:
                current object (this)


        Execution becomes:

        Thread-1 enters method
        Other threads WAIT
        Thread-1 completes
        Lock released
        Next thread executes


        When Synchronization is Required
        --------------------------------
        Synchronization is needed only when:

            1. Multiple threads exist
            2. Shared mutable data exists
            3. Data modification happens

        If any one is missing → synchronization not required.

        ============================================================
    */

    @Override
    public void execute() {

        Random random = new Random();
        List<Thread> threads = new ArrayList<>();

        UserAccount jawahirAccount = new UserAccount("Jawahir", 500);
        double expectedBalance = jawahirAccount.balance;

        for(int i = 1; i <= 10; i++) {
            boolean isCredit = random.nextBoolean();
            double amount = (random.nextInt(10) + 1) * 100;
            expectedBalance = isCredit ? expectedBalance + amount : expectedBalance - amount;
            Thread transaction = new TransactionThread(jawahirAccount, isCredit ? "CREDIT" : "DEBIT", amount);
            threads.add(transaction);
            transaction.start();
        }

        for(Thread t : threads) {
            try {
                t.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        System.out.println("Expected Balance : " + expectedBalance  );
        System.out.println("Balance After All Transactions : " + jawahirAccount.balance);
    }

    class TransactionThread extends Thread {

        UserAccount userAccount;
        String operation;
        double amount;

        TransactionThread(UserAccount userAccount, String operation, double amount) {
            super();
            this.userAccount = userAccount;
            this.operation = operation;
            this.amount = amount;
        }

        @Override
        public void run() {
            try {
                Thread.sleep(1000);
                if (this.operation.equals("CREDIT")) {
                    this.userAccount.credit(amount);
                } else if (this.operation.equals("DEBIT")) {
                    this.userAccount.debit(amount);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    class UserAccount {
        String userName;
        double balance;

        UserAccount(String userName, double amount) {
            this.userName = userName;
            this.balance = amount;
        }

        void credit(double amount) {
            synchronized (this) {
                this.balance += amount;
                System.out.println("Amount " + amount + " Credited");
            }
        }

        void debit(double amount) {
            synchronized (this) {
                this.balance -= amount;
                System.out.println("Amount " + amount + " Debited");
            }
        }
    }

}
