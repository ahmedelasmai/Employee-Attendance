import java.util.ArrayList;

public class EmployeeManager {

    private ArrayList<Employee> employees;



    // Constructor
    public EmployeeManager() {
        employees = new ArrayList<>();

    // preload employees
        employees.add(new Employee(1, "Ahmed"));
        employees.add(new Employee(2, "Sarah"));
        employees.add(new Employee(3, "John"));

    }

    // Add employee
    public void addEmployee(Employee employee) {
        employees.add(employee);
    }

    // Search employee by ID
    public Employee searchEmployeeById(int id) {

        for (Employee emp : employees) {
            if (emp.getEmployeeId() == id) {
                return emp;
            }
        }

        return null;
    }

    // Display all employees
    public void displayAllEmployees() {

        for (Employee emp : employees) {
            emp.displayEmployee();
            System.out.println();
        }
    }
    public ArrayList<Employee> getAllEmployees() {
        return employees;
    }
}
