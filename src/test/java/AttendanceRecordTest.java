import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class AttendanceRecordTest {

    @Test
    void settersAndGettersWork() {
        AttendanceRecord record = new AttendanceRecord(1, "2026-04-01");
        record.setCheckInTime("09:00");
        record.setCheckOutTime("17:00");

        assertEquals("09:00", record.getCheckInTime());
        assertEquals("17:00", record.getCheckOutTime());
    }
}