//package src;
import java.util.ArrayList;

//import ComplianceViolation;

public class ComplianceManager {

    // Check missing check-out
    public ComplianceViolation checkMissingCheckOut(AttendanceRecord record, String employeeName) {

        if (record.getCheckOutTime() == null) {
            return new ComplianceViolation(
                record.getEmployeeId(),
                employeeName,
                "Missing Check-Out",
                record.getDate()
            );
        }

        return null;
    }

    // Check late arrival
    public ComplianceViolation checkLateArrival(AttendanceRecord record, String employeeName) {

        if (record.getCheckInTime() != null) {

            if (record.getCheckInTime().compareTo("09:15") > 0) {

                return new ComplianceViolation(
                    record.getEmployeeId(),
                    employeeName,
                    "Late Arrival",
                    record.getDate()
                );
            }
        }

        return null;
    }

    // Generate violations
    public ArrayList<ComplianceViolation> generateViolations(
            ArrayList<AttendanceRecord> records,
            ArrayList<Employee> employees) {

        ArrayList<ComplianceViolation> violations = new ArrayList<>();

        for (AttendanceRecord record : records) {

            String employeeName = "Unknown";

            // find employee name
            for (Employee emp : employees) {
                if (emp.getEmployeeId() == record.getEmployeeId()) {
                    employeeName = emp.getName();
                    break;
                }
            }

            // check rules
            ComplianceViolation v1 = checkMissingCheckOut(record, employeeName);
            if (v1 != null) {
                violations.add(v1);
            }

            ComplianceViolation v2 = checkLateArrival(record, employeeName);
            if (v2 != null) {
                violations.add(v2);
            }
        }

        return violations;
    }

    public ArrayList<ComplianceViolation> generateDailyViolations(
            ArrayList<AttendanceRecord> records,
            ArrayList<Employee> employees,
            String date) {

        ArrayList<ComplianceViolation> violations = new ArrayList<>();

        for (AttendanceRecord record : records) {

            String employeeName = "Unknown";

            // make sure its only searching for the current date
            if (!record.getDate().equals(date)) {
                continue;
            }
                for (Employee emp : employees) {
                    if (emp.getEmployeeId() == record.getEmployeeId()) {
                        employeeName = emp.getName();
                        break;
                    }
                }


            // check rules
            ComplianceViolation v1 = checkMissingCheckOut(record, employeeName);
            if (v1 != null) {
                violations.add(v1);
            }

            ComplianceViolation v2 = checkLateArrival(record, employeeName);
            if (v2 != null) {
                violations.add(v2);
            }
        }

        return violations;

    }
}