package CustomThreadPool;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class CustomThreadPool {

    private List<Worker> workers;
    private BlockingQueue<Runnable> taskQueue;
    private volatile boolean isShutdown;


    public CustomThreadPool(int maxThreads, int queueSize) {
        taskQueue = new ArrayBlockingQueue<Runnable>(queueSize);
        workers = new ArrayList<>(maxThreads);
        for(int i = 0; i < maxThreads; i++) {
            Worker worker = new Worker("Thread-" + i);
            workers.add(worker);
            worker.start();
        }
        isShutdown = false;
    }

    public void shutdown() {
        isShutdown = true;
        synchronized(taskQueue){
            taskQueue.notifyAll();
        }
    }

    public void submit(Runnable task) {
        if (isShutdown)
            throw new RuntimeException("Thread pool is shutdown. Cannot accept new tasks.");
        synchronized (taskQueue)
        {
        if (taskQueue.remainingCapacity() > 0) {
            taskQueue.offer(task);
            taskQueue.notify();
        }
        else
            throw new RuntimeException("All threads are busy. Please try again later.");
        }
    }

    private class Worker extends Thread{
        public Worker(String name) {
            super(name);
        }

        // all threads monitor the same task queue, so that they can pick up tasks as they become available
        @Override
        public void run() {
            while (true) {
                try
                {
                    Runnable task;
                    synchronized (taskQueue)
                    {
                        if(isShutdown)
                            break;

                        if(taskQueue.isEmpty())
                        {
                            taskQueue.wait();
                        }
                        task = taskQueue.take();
                    }
                    task.run();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    break;
                }
            }
        }
    }
}

