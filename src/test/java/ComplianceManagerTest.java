import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.*;

public class ComplianceManagerTest {

    @Test
    void lateArrival_shouldGenerateViolation() {
        ComplianceManager manager = new ComplianceManager();

        AttendanceRecord record =
                new AttendanceRecord(1, "2026-04-09");
        record.setCheckInTime("09:30"); // after 09:15

        ArrayList<AttendanceRecord> records = new ArrayList<>();
        records.add(record);

        ArrayList<Employee> employees = new ArrayList<>();
        employees.add(new Employee(1, "Ahmed"));

        ArrayList<ComplianceViolation> violations =
                manager.generateViolations(records, employees);

        assertEquals(1, violations.size());
        assertEquals("Late Arrival",
                violations.get(0).getViolationType());
    }

    @Test
    void missingCheckout_shouldGenerateViolation() {
        ComplianceManager manager = new ComplianceManager();

        AttendanceRecord record =
                new AttendanceRecord(2, "2026-04-09");
        record.setCheckInTime("09:00");

        ArrayList<AttendanceRecord> records = new ArrayList<>();
        records.add(record);

        ArrayList<Employee> employees = new ArrayList<>();
        employees.add(new Employee(2, "Sarah"));

        ArrayList<ComplianceViolation> violations =
                manager.generateViolations(records, employees);

        assertEquals(1, violations.size());
        assertEquals("Missing Check-Out",
                violations.get(0).getViolationType());
    }

    @Test
    void noViolation_shouldReturnEmptyList() {
        ComplianceManager manager = new ComplianceManager();

        AttendanceRecord record =
                new AttendanceRecord(3, "2026-04-09");
        record.setCheckInTime("09:00");
        record.setCheckOutTime("17:30");

        ArrayList<AttendanceRecord> records = new ArrayList<>();
        records.add(record);

        ArrayList<Employee> employees = new ArrayList<>();
        employees.add(new Employee(3, "John"));

        ArrayList<ComplianceViolation> violations =
                manager.generateViolations(records, employees);

        assertTrue(violations.isEmpty());
    }
}