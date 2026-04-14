import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ComplianceViolationTest {

    @Test
    void violationStoresValues() {
        ComplianceViolation v =
                new ComplianceViolation(1, "Ahmed", "Late Arrival", "2026-04-01");

        assertEquals("Ahmed", v.getEmployeeName());
        assertEquals("Late Arrival", v.getViolationType());
        assertEquals("2026-04-01", v.getDate());
    }
}