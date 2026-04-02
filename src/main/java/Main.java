    import java.util.ArrayList;
    import java.util.Scanner;

    import java.time.LocalDate;
    import java.time.format.DateTimeFormatter;


    public class Main {

        public static void main(String[] args) {

            Scanner sc = new Scanner(System.in);
            boolean running = true;

            EmployeeManager employeeManager = new EmployeeManager();
            ComplianceManager complianceManager = new ComplianceManager();
            ReportManager reportManager = new ReportManager();


            while (running) {

                System.out.println("""
                        ----------------------------
                        ATTENDANCE COMPLIANCE SYSTEM
                        ----------------------------
                        1. Quit
                        2. See Compliance Violations
                        3. daily violations
                        4. Check in
                        5. Check out
                        6. See employees
                        7. Create employee
                        8. See attendance record
                        9. View all attendance records
                        10. generate CSV report
                        ----------------------------
                        Enter choice:
                        """);

                int choice = sc.nextInt();
                sc.nextLine(); // consume newline

                switch (choice) {

                    case 1:
                        System.out.println("Exiting...");
                        running = false;
                        break;

                    case 2:
                        System.out.println("Policy violations:");
                        java.util.ArrayList<ComplianceViolation> violations =
                                complianceManager.generateViolations(
                                        AttendanceManager.attendanceRecords,
                                        employeeManager.getAllEmployees()
                                );

                        if (violations.isEmpty()) {
                            System.out.println("No violations found.");
                        } else {
                            for (ComplianceViolation v : violations) {
                                v.displayViolation();
                            }
                        }
                        break;

                    case 3:
                        System.out.println(" daily ");
                        break;

                    case 4:
                        System.out.println("Enter employeeId, date (DD-MM-YYYY), check-in time (HH:MM)");
                        int inId = sc.nextInt();
                        sc.nextLine();
                        String inDate = sc.nextLine();
                        String checkInTime = sc.nextLine();

                        AttendanceManager.checkIn(inId, inDate, checkInTime);
                        System.out.println("Check-in successful.");
                        break;

                    case 5:
                        System.out.println("Enter employeeId, date (DD-MM-YYYY), check-out time (HH:MM)");
                        int outId = sc.nextInt();
                        sc.nextLine();
                        String outDate = sc.nextLine();
                        String checkOutTime = sc.nextLine();

                        AttendanceManager.checkOut(outId, outDate, checkOutTime);
                        System.out.println("Check-out successful.");
                        break;

                    case 6:
                        employeeManager.displayAllEmployees();
                        break;

                    case 7:
                        System.out.println("Enter employeeId and name");
                        int empId = sc.nextInt();
                        sc.nextLine();
                        String name = sc.nextLine();

                        employeeManager.addEmployee(new Employee(empId, name));
                        System.out.println("Employee created.");
                        break;

                    case 8:
                        System.out.println("Enter employeeId and date (DD-MM-YYYY)");
                        int searchId = sc.nextInt();
                        sc.nextLine();
                        String searchDate = sc.nextLine();

                        AttendanceManager.findAttendanceRecord(searchId, searchDate);
                        break;

                    case 9:
                        AttendanceManager.displayAllAttendanceRecords();
                        break;

                    case 10:
                        System.out.println("generating CSV report for (YYYY-MM-DD)");
                        LocalDate today = LocalDate.now();

                        DateTimeFormatter formatter =
                                DateTimeFormatter.ofPattern("yyyy-MM-dd");
                        String formattedDate = today.format(formatter);

                        ArrayList<ComplianceViolation> dailyViolations =
                                complianceManager.generateViolations(
                                        AttendanceManager.attendanceRecords,
                                        employeeManager.getAllEmployees()
                                );
                        ReportManager.generateCsvReport(dailyViolations,
                                "attendance_violations_" + formattedDate + ".csv");

                        break;

                    default:
                        System.out.println("Invalid choice.");
                }
            }

            sc.close();
        }
    }