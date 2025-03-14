

public class Client {

    public static void main(String[] args) {
            
    Student s = new Student("John", 20, "1234 Main St.");
    Student s2 = s.copy();

    Student is = new IntelligentStudent("Jane", 21, "5678 Elm St.", "Smart"); 
    
    // is2 is an IntelligentStudent not Student
    Student is2 = is.copy();
    }

}
