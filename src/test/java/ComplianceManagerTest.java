import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.*;

public class ComplianceManagerTest {

    @Test
    void lateArrival_onlyViolation() {
        AttendanceRecord record = new AttendanceRecord(1, "2026-04-01");
        record.setCheckInTime("09:30");
        record.setCheckOutTime("17:30");

        ArrayList<AttendanceRecord> records = new ArrayList<>();
        records.add(record);

        ArrayList<Employee> employees = new ArrayList<>();
        employees.add(new Employee(1, "Ahmed"));

        ComplianceManager manager = new ComplianceManager();
        ArrayList<ComplianceViolation> violations =
                manager.generateViolations(records, employees);

        assertEquals(1, violations.size());
        assertEquals("Late Arrival", violations.get(0).getViolationType());
    }

    @Test
    void missingCheckOut_violationGenerated() {
        AttendanceRecord record = new AttendanceRecord(1, "2026-04-01");
        record.setCheckInTime("09:00");

        ArrayList<AttendanceRecord> records = new ArrayList<>();
        records.add(record);

        ArrayList<Employee> employees = new ArrayList<>();
        employees.add(new Employee(1, "Ahmed"));

        ComplianceManager manager = new ComplianceManager();
        ArrayList<ComplianceViolation> violations =
                manager.generateViolations(records, employees);

        assertEquals(1, violations.size());
    }
}