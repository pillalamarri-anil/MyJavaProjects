package DesignPatterns.src.Registry;


public class Client {

    static void fillRegistry(EmployeeRegistry registry) {
        registry.register("developer", new Developer());
        registry.register("tester", new Tester());
    }

    public static void main(String[] args) {
            
    EmployeeRegistry registry = new EmployeeRegistry();
    fillRegistry(registry);

    Employee developer = registry.get("developer");
    Employee tester = registry.get("Tester");
    }
}
