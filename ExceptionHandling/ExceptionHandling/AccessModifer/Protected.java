package AccessModifer;

import java.util.Arrays;
import java.util.List;

// protected methods are accessible within the same package even if it is not subclass
// private methods are not accessible outside the class
class test{

    static protected void display(){
        System.out.println("Protected method");
    }

    static private void display1(){
        System.out.println("Private method");
    }

}

public class Protected {

    public static void main(String[] args) {
        test.display();

     //   test.display1();

    }

}
