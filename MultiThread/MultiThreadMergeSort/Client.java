package MultiThread.MultiThreadMergeSort;

import java.util.Arrays;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Client {
    public static void main(String[] args) throws ExecutionException, InterruptedException {

        int[] in = new int[]{72,36,82,26,61,83,51};

        // CachedThreadPool creates as many new threads as required... 
        // to make the program not to wait anywhere, we make it CachedThreadPool
        // fixedthreadpool with no of fixed threads = 1 causes hang as recursion call spins 2 more threads
        // it wil wait for parent thread to complete which never completes.
        ExecutorService es = Executors.newCachedThreadPool();

        MergeSort sorter = new MergeSort(in, es);

        Future<int[]> future = es.submit(sorter);

        int[] ans = future.get();



        es.shutdown();

        System.out.println(Arrays.toString(ans));
    }
    
}
