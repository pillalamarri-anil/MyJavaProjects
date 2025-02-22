public class Client {

    public static void main(String[] args) {

        // this will print "Finally Block" and "Null Pointer Exception"
        // Null pointer exception thrown from catch block is not caught, it will be directed to console.

        try {
            String str = null;
            System.out.println(str.length());
        } catch (NullPointerException e) {
            String str = null;
            System.out.println(str.length());
            System.out.println("Null Pointer Exception Caught");
        } finally {
            System.out.println("Finally Block");
        }
        
    }

}
