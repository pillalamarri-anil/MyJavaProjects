package MultiThread.volatileExample;

class SharedResource {
    
    // volatile makes tells compiler to always read value from heap and not from thread cache
    volatile  private boolean flag;

    public SharedResource(boolean flag) {
        this.flag = flag;
    }

    public void toggle()
    {
        flag = !flag;
    }

    public boolean getFlag()
    {
        return flag;
    }

}

public class volatileEx {

    public static void main(String[] args) {


        SharedResource s = new SharedResource(false);

        Thread t1 = new Thread(()->
        {
            try {
                Thread.sleep(1000);

                s.toggle();
                System.out.println("Thread A finised");
                System.out.println("Flag value in Thread A: " +s.getFlag());

            } catch (InterruptedException ex) {
            }
        });

        Thread t2 = new Thread(()->
        {
            while(!s.getFlag())
            {
          //      System.out.println("Waiting for Thread A to finish");
            }
            System.out.println("Thread B finised");
            System.out.println("Flag value in Thread B: " +s.getFlag());
        });

        t1.start();
        t2.start();
    }

}
