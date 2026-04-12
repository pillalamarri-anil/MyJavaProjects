package MultiThread.ThreadLocal;


// ThreadLocal allows you to create variables that are local to each thread.
// Each thread has its own copy of the variable, and changes made by one thread do not affect the variable in other threads.
// This is particularly useful for maintaining thread-specific data without the need for synchronization.
public class ThreadLocalExample {

    private static ThreadLocal<Integer> threadLocal = ThreadLocal.withInitial(() -> 0);

    public static void main(String[] args) {



        Thread thread1 = new Thread(() -> {
            threadLocal.set(threadLocal.get() + 1);
            System.out.println("thread1: threadlocal = " + threadLocal.get());
        });

        Thread thread2 = new Thread(() -> {
            threadLocal.set(threadLocal.get() + 1);
            System.out.println("thread2: threadlocal = " + threadLocal.get());
        });

        thread1.start();
        thread2.start();

        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

