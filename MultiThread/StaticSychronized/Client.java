package MultiThread.StaticSychronized;

class Counter {

    public static int count = 0;

    // static method is synchronized
    // this ensures that only one thread can execute this method at a time
    public static synchronized void increment()
    {
        count++;
    }

}

public class Client {

    public static void main(String[] args) throws InterruptedException {

    Thread t1 = new Thread(new Runnable() {
        @Override
        public void run() {
            for(int i = 0; i < 1000; i++)
                Counter.increment();
        }
    });

    Thread t2 = new Thread(new Runnable(){
        @Override
        public void run() {
            for(int i = 0; i < 1000; i++)
                Counter.increment();
        }
    });

    t1.start();
    t2.start();

    t1.join(0);
    t2.join(0);

    System.out.println("Final count: " + Counter.count);
    }
}
