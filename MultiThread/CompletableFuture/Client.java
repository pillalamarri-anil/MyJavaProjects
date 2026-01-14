package MultiThread.CompletableFuture;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class Client {

    public static void main(String[] args) {

        ArrayList<Integer> list = new ArrayList<Integer>();

        list.stream().filter(e -> e % 2 == 0).reduce(0, (a, b) -> a + b);

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
