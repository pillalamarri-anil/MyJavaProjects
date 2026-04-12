package CustomThreadPool;

public class Client {
    public static void main(String[] args) {
        CustomThreadPool customThreadPool = new CustomThreadPool(3, 20);

        for (int i = 0; i < 10; i++) {
            final int taskId = i;
            customThreadPool.submit(() -> {
                System.out.println("Task " + taskId + " is running on thread " + Thread.currentThread().getName());
            });
        }

        customThreadPool.shutdown();
    }
}
