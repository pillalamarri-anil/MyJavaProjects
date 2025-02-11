package MultiThread.ArrayListUsingCallable;

import java.util.ArrayList;
import java.util.concurrent.Callable;

public class Adder implements Callable<Object>
{
    private int n;
    public Adder(int n)
    {
        this.n = n;
    }

     @Override
    public ArrayList<Integer> call()
    {
        ArrayList<Integer> ans = new ArrayList();
        for(int i = 1; i <= n; i++)
            ans.add(i);

        return ans;
    }
    
}
