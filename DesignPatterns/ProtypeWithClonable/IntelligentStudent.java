

public class IntelligentStudent extends Employee {

    private String intelligence;

    public IntelligentStudent(String name, int age, String address, String intelligence) {
        super(name, age, address);
        this.intelligence = intelligence;
    }

    public IntelligentStudent(IntelligentStudent student) {
        super(student);
        this.intelligence = student.intelligence;
    }

    public IntelligentStudent clone() { 
        return new IntelligentStudent(this);
    }

}
