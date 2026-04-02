public class Employee {

    private int employeeId;
    private String name;

    // Constructor
    public Employee(int employeeId, String name) {
        this.employeeId = employeeId;
        this.name = name;
    }

    // Getter for employeeId
    public int getEmployeeId() {
        return employeeId;
    }

    // Getter for name
    public String getName() {
        return name;
    }

    // Display method
    public void displayEmployee() {
        System.out.println("Employee ID: " + employeeId);
        System.out.println("Employee Name: " + name);
    }
}

