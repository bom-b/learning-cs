package syncronization;

public class Threads {
    private static final int NUM_THREADS = 4;
    private static int shared = 0;

    public static void main(String[] args) throws  InterruptedException {
        Thread[] threads = new Thread[NUM_THREADS];

        for (int i = 0; i < NUM_THREADS; i++) {
            threads[i] = new Thread(Threads::foo);
            threads[i].start();
        }

        for (int i = 0; i < NUM_THREADS; i++) {
            threads[i].join();
        }

        System.out.println("final result is " + shared);
    }

    static void foo() {
        for (int i = 0; i < 10000; i++) {
            shared += 1;
        }
    }
}