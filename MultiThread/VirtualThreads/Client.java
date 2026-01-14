package MultiThread.VirtualThreads;

public class Client {

    public static void main(String[] args) {

        try {
            Thread virtualThread = Thread.startVirtualThread(() -> System.out.println("Virtual Thread: " + Thread.currentThread().getName()));
            virtualThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
