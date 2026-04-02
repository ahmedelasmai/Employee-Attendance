//package src;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

//import ComplianceViolation;

public class ReportManager {

    public static void generateCsvReport(ArrayList<ComplianceViolation> violations, String fileName) {
        try {
            FileWriter writer = new FileWriter(fileName);

            writer.write("Employee ID,Employee Name,Violation Type,Date\n");

            for (ComplianceViolation violation : violations) {
                writer.write(
                    violation.getEmployeeId() + "," +
                    violation.getEmployeeName() + "," +
                    violation.getViolationType() + "," +
                    violation.getDate() + "\n"
                );
            }

            writer.close();
            System.out.println("CSV report generated successfully: " + fileName);

        } catch (IOException e) {
            System.out.println("Error writing CSV file.");
            e.printStackTrace();
        }
    }
}