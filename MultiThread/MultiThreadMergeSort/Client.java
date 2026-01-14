package MultiThread.MultiThreadMergeSort;

import java.util.*;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Client {
    public static void main(String[] args) throws ExecutionException, InterruptedException {

        int[] in = new int[]{72,36,82,26,61,83,51, 7908, 65867, 6987, 6987, 5869, 5869, 697, 70, 0, 345};

        // CachedThreadPool creates as many new threads as required...
        // to make the program not to wait anywhere, we make it CachedThreadPool
        // fixedthreadpool with no of fixed threads = 1 causes hang as recursion call spins 2 more threads
        // it wil wait for parent thread to complete which never completes.
        ExecutorService es = Executors.newCachedThreadPool();

        Vector<Integer> v = new Vector<>();
        MergeSort sorter = new MergeSort(in, es);

        Deque<Integer> deque = new LinkedList<>();

        ArrayDeque<Integer> arrayDeque = new ArrayDeque<>();

        Future<int[]> future = es.submit(sorter);

        int[] ans = future.get();

        Lock lock = new ReentrantLock();


        es.shutdown();

        System.out.println(Arrays.toString(ans));
    }

}
