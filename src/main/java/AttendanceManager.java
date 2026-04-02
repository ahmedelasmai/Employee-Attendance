import exceptions.AttendanceRecordAlreadyExistsException;

import java.util.ArrayList;
import java.util.Objects;

public class AttendanceManager {

    static ArrayList<AttendanceRecord> attendanceRecords = new ArrayList<>();

    public static void checkIn(int employeeId, String date, String checkInTime) {
        for (AttendanceRecord record : attendanceRecords) {
            if (record.getEmployeeId() == employeeId &&
            Objects.equals(record.getDate(), date)) {
                throw new AttendanceRecordAlreadyExistsException(
                        "Employee: " + employeeId + "has already check in for the date: " + date
                );
            }
        }
        AttendanceRecord record = new AttendanceRecord(employeeId, date);
        record.setCheckInTime(checkInTime);
        attendanceRecords.add(record);
    }

    public static void checkOut(int employeeId, String date, String checkOutTime) {
        for (AttendanceRecord record : attendanceRecords) {
            if (record.getEmployeeId() == employeeId &&
                    record.getDate().equals(date)) {

                record.setCheckOutTime(checkOutTime);
                return;
            }
        }

        System.out.println("No check-in record found.");
    }

    public static void findAttendanceRecord(int employeeId, String date) {
        for (AttendanceRecord record : attendanceRecords) {
            if (record.getEmployeeId() == employeeId &&
                    Objects.equals(record.getDate(), date)) {
                record.displayAttendanceRecord();
                return;
                }
            }
        System.out.println("not found");
        }


    public static void displayAllAttendanceRecords() {
        for (AttendanceRecord record : attendanceRecords) {
            record.displayAttendanceRecord();
        }
    }
}