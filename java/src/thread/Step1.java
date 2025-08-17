package thread;

class MyThread extends Thread {
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println("Thread is running: " + i);
        }
    }
}

public class Step1 {
    public static void main(String[] args) {
        MyThread t = new MyThread();
        t.start();
    }
}