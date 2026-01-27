package MultiThread.CompletableFuture;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.concurrent.*;

public class Client {

    public static void main(String[] args) {

        ArrayList<Integer> list = new ArrayList<Integer>();

        list.stream().filter(e -> e % 2 == 0).reduce(0, (a, b) -> a + b);

        CompletableFuture<Integer> cf1 = CompletableFuture.supplyAsync(()-> 2);
        cf1.thenComposeAsync(result -> CompletableFuture.supplyAsync(()-> 3 * result));

        ForkJoinTask ft = ForkJoinTask.adapt(()-> System.out.println("hello"));
        ft.fork();

        ExecutorService executorService = Executors.newWorkStealingPool(10);

        ExecutorService esVirtual = Executors.newVirtualThreadPerTaskExecutor();


        CompletableFuture<Integer> future = CompletableFuture.supplyAsync(() ->
        {
            try {
                Thread.sleep(1000);
                }    
            catch (InterruptedException ex) {
            }
            return 5;
        });

        // from the result 
        CompletableFuture<Integer> f1 = future.thenApplyAsync(result -> 2 * result);


        try {
            System.out.println(f1.get());
        } catch (InterruptedException ex) {
        } catch (ExecutionException ex) {
        }



        CompletableFuture<Integer> f2 = future.thenApply(result -> 3 * result);
       
        try {
            System.out.println(f2.get());
        } catch (InterruptedException ex) {
        } catch (ExecutionException ex) {
        }

        CompletableFuture<String> f3 = CompletableFuture.supplyAsync(()->"Hello");
        f3.thenAccept(result -> System.out.println(result + " World"));

        BigInteger bigInteger = new BigInteger("1");

    }
}
