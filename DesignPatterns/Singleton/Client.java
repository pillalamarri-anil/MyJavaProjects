package DesignPatterns.Singleton;

enum eSingleton
{
    INSTANCE; // eager initialization

    private String name;

    eSingleton() 
    {
        name = "Singleton";
    }

    public void setName(String name)
    {
        this.name = name;
    }   

    public void Print()
    {
        System.out.println(name);
    }
}


class LazySingleton {

    private static LazySingleton instance;

    private String name;

    public void setName(String name)
    {
        this.name = name;
    }

    public String getName()
    {
        return name;
    }

    private LazySingleton()
    {
    }

    public static LazySingleton getInstance()
    {
        if(instance == null)
        {
            synchronized(LazySingleton.class) // do not use instance here as it is null
            {
                if(instance ==  null)
                {
                    instance = new LazySingleton();
                }
            }
        }
        return instance;
    }
}

public class Client {

public static void main(String[] args) {

    eSingleton.INSTANCE.setName("test name");
    eSingleton.INSTANCE.Print();

    LazySingleton obj1 = LazySingleton.getInstance();
    LazySingleton obj2 = LazySingleton.getInstance();

    obj1.setName("test name");
    System.out.println(obj2.getName()); 
}


}
