package MultiThread.ProducerConsumer;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Store {

   private int _maxSize;
    private  ArrayList<Object> _store;

    public Store(int maxSize) {
        _maxSize = maxSize;
        _store = new ArrayList<Object>();
    }

    int getCurrSize() {
        return _store.size();
    }

    int getMaxSize() {
        return _maxSize;
    }

    public void increment() {
    
        System.out.println("Producer produced an item: " + _store.size());
        _store.add(new Object());
    }

    public void decrement() {
    
        System.out.println("Consumer consumed an item: " + _store.size());
        _store.remove(_store.size() - 1);
    }
}
