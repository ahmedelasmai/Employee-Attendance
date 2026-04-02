public class AttendanceRecord {
    private final int employeeId;
    String date;
    String checkInTime;
    String checkOutTime;

    public AttendanceRecord(int employeeId, String date) {
        this.employeeId = employeeId;
        this.date = date;
    }


    public void displayAttendanceRecord() {
        System.out.println("AttendanceRecord{" +
                "employeeId=" + employeeId +
                ", date='" + date + '\'' +
                ", checkInTime='" + checkInTime + '\'' +
                ", checkOutTime='" + checkOutTime + '\'' +
                '}');
    }

    public void setCheckInTime(String checkInTime) {
        this.checkInTime = checkInTime;
    }

    public void setCheckOutTime(String checkOutTime) {
        this.checkOutTime = checkOutTime;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public String getDate() {
        return date;
    }

    public String getCheckInTime() {
        return checkInTime;
    }

    public String getCheckOutTime() {
        return checkOutTime;
    }
}