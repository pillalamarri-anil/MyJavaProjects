
public class Student implements Cloneable {

    private String name;
    private int age;
    private String address;

    public Student(String name, int age, String address) {
        this.name = name;
        this.age = age;
        this.address = address;
    }

    public Student(Student student) {
        this.name = student.name;
        this.age = student.age;
        this.address = student.address;
    }

    public Student Clone() {
        return new Student(this);
    }

}
