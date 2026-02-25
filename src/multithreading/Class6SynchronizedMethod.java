package multithreading;

import multithreading.handler.ThreadHandler;

public class Class6SynchronizedMethod extends ThreadHandler {

    @Override
    public void execute() {
        UserAccount jawahirAccount = new UserAccount("Jawahir", 500);
        Thread transaction1 = new TransactionThread(jawahirAccount, "CREDIT", 100);
        Thread transaction2 = new TransactionThread(jawahirAccount, "DEBIT", 200);
        Thread transaction3 = new TransactionThread(jawahirAccount, "DEBIT", 300);
        Thread transaction4 = new TransactionThread(jawahirAccount, "CREDIT", 500);

        transaction1.start();
        transaction2.start();
        transaction3.start();
        transaction4.start();

        try {
            transaction1.join();
            transaction2.join();
            transaction3.join();
            transaction4.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Expected Balance : " + (500 + 100 - 200 - 300 + 500));
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

        synchronized void credit(double amount) {
            this.balance += amount;
            System.out.println("Amount " + amount + " Credited");
        }

        synchronized void debit(double amount) {
            this.balance -= amount;
            System.out.println("Amount " + amount + " Debited");
        }
    }
}
