package ExceptionHandling.DesignPatterns.Singleton;

class Singleton
{
    private static Singleton instance;

    private Singleton()
    {
    }

    static public Singleton getInstance()
    {
        if(instance == null)
        {
            synchronized(instance)
            {
                if(instance ==  null)
                {
                    instance = new Singleton();
                }
            }
        }
    
        return instance;
    }

}

public class multiThreadSingleton {

    public static void main(String[] args) {
        Singleton obj1 = Singleton.getInstance();
        Singleton obj2 = Singleton.getInstance();
        System.out.println(obj1 == obj2);
    }

}
