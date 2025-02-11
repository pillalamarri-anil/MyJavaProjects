package MultiThread.MultiThreadMergeSort;

import java.util.Arrays;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

public class MergeSort implements Callable {

    private int[] _array;
    private ExecutorService _es;

    public MergeSort(int[] in, ExecutorService es)
    {
        _array = in;
        _es = es;
    }

    @Override
    public int[] call() throws Exception 
    {

        int size = _array.length;

        if(size <= 1)
            return _array;

       int[] left =  Arrays.copyOfRange(_array, 0, size/2);
       int[] right = Arrays.copyOfRange(_array, size/2, size);

       Callable leftSort = new MergeSort(left, _es);
       Callable rightSort = new MergeSort(right, _es);

       Future<int[]> leftFuture = _es.submit(leftSort);
       Future<int[]> rightFuture = _es.submit(rightSort);

       int[] leftSorted = leftFuture.get();
       int[] rightSorted = rightFuture.get();

       int l = 0, r = 0;
       int[] ans = new int[size];
       int itr = 0;
       while(l < leftSorted.length && r < rightSorted.length)
       {
            if(leftSorted[l] <= rightSorted[r])
            {
                ans[itr++] = leftSorted[l++];
            }
            else
            {
                ans[itr++] = rightSorted[r++];
            }
       }

       while( l < leftSorted.length)
        ans[itr++] = leftSorted[l++];
       while(r < rightSorted.length)
        ans[itr++] = rightSorted[r++];

        return ans;

    }    
}
