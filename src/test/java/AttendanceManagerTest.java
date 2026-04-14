import exceptions.AttendanceRecordAlreadyExistsException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class AttendanceManagerTest {

    @BeforeEach
    void resetRecords() {
        AttendanceManager.attendanceRecords.clear();
    }

    @Test
    void checkIn_createsAttendanceRecord() {
        AttendanceManager.checkIn(1, "2026-04-01", "09:00");
        assertEquals(1, AttendanceManager.attendanceRecords.size());
    }

    @Test
    void checkOut_setsCheckoutTime() {
        AttendanceManager.checkIn(1, "2026-04-01", "09:00");
        AttendanceManager.checkOut(1, "2026-04-01", "17:00");

        AttendanceRecord record = AttendanceManager.attendanceRecords.get(0);
        assertEquals("17:00", record.getCheckOutTime());
    }

    @Test
    void duplicateCheckIn_throwsException() {
        AttendanceManager.checkIn(1, "2026-04-01", "09:00");

        assertThrows(
                AttendanceRecordAlreadyExistsException.class,
                () -> AttendanceManager.checkIn(1, "2026-04-01", "09:05")
        );
    }
}
