package DesignPatterns.Builder;

public class Client {

    public static void main(String[] args) {
        
        Student s = Student.getBuilder()
            .setName("John")
            .setAge(10)
            .setAddress("123 Main St")
            .setSchool("ABC School")
            .setGrade("5th")
            .setTeacher("Mr. Smith")
            .setParent("Mr. and Mrs. Doe")
            .build();

        System.out.println(s);
    }

}
