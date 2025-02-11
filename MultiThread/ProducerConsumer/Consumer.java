package MultiThread.ProducerConsumer;

public class Consumer implements Runnable {
    
        Store _store;
    
        public Consumer(Store store) {
            _store = store;
        }
    
        public void consume() {
    
            if(_store.getCurrSize() > 0) {
                _store.decrement();
            }
        }

        @Override
        public void run() {
            
            while (true)
            {
                synchronized(_store) 
                {
                    consume();
                }
            }
        }

}
