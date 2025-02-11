package MultiThread.ProducerConsumer;

public class Producer implements Runnable {

    Store _store;

    public Producer(Store store) {
        _store = store;
    }

    public void produce() {

        if(_store.getCurrSize() < _store.getMaxSize()) {
            _store.increment();
        }
    }

    @Override
    public void run() {
        
        while (true)
        {
            synchronized   (_store) 
            {
                produce();
            }
        }
    }



}
