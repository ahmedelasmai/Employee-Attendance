import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class EmployeeManagerTest {

    @Test
    void addEmployee_thenSearch_returnsEmployee() {
        EmployeeManager manager = new EmployeeManager();
        Employee employee = new Employee(1, "Ahmed");

        manager.addEmployee(employee);

        Employee result = manager.searchEmployeeById(1);
        assertNotNull(result);
        assertEquals("Ahmed", result.getName());
    }

    @Test
    void searchEmployee_notFound_returnsNull() {
        EmployeeManager manager = new EmployeeManager();
        assertNull(manager.searchEmployeeById(999));
    }
}