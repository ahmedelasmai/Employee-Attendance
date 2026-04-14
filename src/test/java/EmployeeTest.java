import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class EmployeeTest {

    @Test
    void employeeStoresValues() {
        Employee e = new Employee(1, "Ahmed");
        assertEquals(1, e.getEmployeeId());
        assertEquals("Ahmed", e.getName());
    }
}