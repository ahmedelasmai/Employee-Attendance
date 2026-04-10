import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class EmployeeManagerTest {

    @Test
    void addAndSearchEmployee_shouldReturnEmployee() {
        EmployeeManager manager = new EmployeeManager();

        Employee emp = new Employee(1, "Ahmed");
        manager.addEmployee(emp);

        Employee result = manager.searchEmployeeById(1);

        assertNotNull(result);
        assertEquals("Ahmed", result.getName());
    }

    @Test
    void searchEmployee_nonExisting_shouldReturnNull() {
        EmployeeManager manager = new EmployeeManager();

        Employee result = manager.searchEmployeeById(999);

        assertNull(result);
    }
}