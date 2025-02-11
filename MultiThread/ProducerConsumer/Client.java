package MultiThread.ProducerConsumer;

import java.util.concurrent.ExecutorService;

public class Client {

    public static void main(String[] args) {
            
            Store store = new Store(10);
            
            Producer producer = new Producer(store);
            Consumer consumer = new Consumer(store);
            
            ExecutorService es = java.util.concurrent.Executors.newCachedThreadPool();

            for(int  i = 0; i < 10; i++) {
                es.execute(producer);
            }

            for(int  i = 0; i < 10; i++) {
                es.execute(consumer);
            }

        }


}
