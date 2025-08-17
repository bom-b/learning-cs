package syncronization;

class BankAccount {
    private int balance = 1000;

    public void withdraw(int money) {
        if (balance >= money) {
            System.out.println(Thread.currentThread().getName() + " 출금중...");
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            balance -= money;
            System.out.println("남은 잔액 : " + balance);
        }
    }

    public int getBalance() {
        return balance;
    }
}

public class RaceCondition {
    public static void main(String[] args) {
        BankAccount account = new BankAccount();

        Runnable task = () -> {
            for (int i = 0; i < 3; i++) {
                account.withdraw(500);
            }
        };

        Thread thread1 = new Thread(task, "스레드 1");
        Thread thread2 = new Thread(task, "스레드 2");

        thread1.start();
        thread2.start();
    }
}
