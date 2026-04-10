import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class AttendanceManagerTest {

    @BeforeEach
    void resetRecords() {
        AttendanceManager.attendanceRecords.clear();
    }

    @Test
    void checkIn_shouldCreateAttendanceRecord() {
        AttendanceManager.checkIn(1, "2026-04-09", "09:00");

        assertEquals(1, AttendanceManager.attendanceRecords.size());
        assertEquals("09:00",
                AttendanceManager.attendanceRecords.get(0).getCheckInTime());
    }

    @Test
    void checkOut_shouldSetCheckOutTime() {
        AttendanceManager.checkIn(1, "2026-04-09", "09:00");
        AttendanceManager.checkOut(1, "2026-04-09", "17:30");

        AttendanceRecord record = AttendanceManager.attendanceRecords.get(0);
        assertEquals("17:30", record.getCheckOutTime());
    }
}