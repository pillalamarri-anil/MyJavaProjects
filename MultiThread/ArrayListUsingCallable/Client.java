package MultiThread.ArrayListUsingCallable;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

public class Client {

    public static void main(String[] args) throws InterruptedException, ExecutionException {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        Adder ac = new Adder(n);

        ExecutorService es = java.util.concurrent.Executors.newSingleThreadExecutor();

        Future<Object> future =  es.submit(ac);

        ArrayList<Integer> ans = (ArrayList<Integer>)(future.get());

        System.out.println(ans);

        es.shutdown();

        System.out.println(ans);

    }
    
}
