
import java.util.HashMap;



public class EmployeeRegistry {

    private HashMap<String, Employee> employees = new HashMap<String, Employee>();

    public void register(String type, Employee employee) {
        employees.put(type, employee);
    }

    public Employee get(String type) {
        Employee employee = employees.get(type);
        return employee.clone();
    }
}

