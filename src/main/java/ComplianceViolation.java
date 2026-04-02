public class ComplianceViolation {

    private int employeeId;
    private String employeeName;
    private String violationType;
    private String date;

    public ComplianceViolation(int employeeId, String employeeName, String violationType, String date) {
        this.employeeId = employeeId;
        this.employeeName = employeeName;
        this.violationType = violationType;
        this.date = date;
    }

    public String getDate() {
        return date;
    }

    public String getViolationType() {
        return violationType;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void displayViolation() {
        System.out.println( "ComplianceViolation{" +
                "employeeId=" + employeeId +
                ", employeeName='" + employeeName + '\'' +
                ", violationType='" + violationType + '\'' +
                ", date='" + date + '\'' +
                '}');
    }


}
