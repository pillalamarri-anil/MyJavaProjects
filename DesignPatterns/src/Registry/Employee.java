package DesignPatterns.src.Registry;

public class Employee implements Cloneable {

    private String specialization;

    public Employee( String specialization) {
        this.specialization = specialization;
    }

    public Employee(Employee employee) {
        this.specialization = employee.specialization;

    
    }

    public Employee clone() {
       return new Employee(this);

    }

}
