import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DatabaseManager {

    private final String URL = "jdbc:postgresql://localhost:5432/attendance_db";
    private final String USER = "postgres";
    private final String PASSWORD = "";

    public Connection connect() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    public void testConnection() {
        try (Connection conn = connect()) {
            System.out.println("Database connected successfully.");
        } catch (SQLException e) {
            System.out.println("Database connection failed.");
            e.printStackTrace();
        }
    }

    public void saveEmployee(Employee employee) {
        String sql = "INSERT INTO employees (id, name) VALUES (?, ?)";

        try (Connection conn = connect();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, employee.getId());
            stmt.setString(2, employee.getName());
            stmt.executeUpdate();

            System.out.println("Employee inserted successfully.");

        } catch (SQLException e) {
            System.out.println("Failed to insert employee.");
            e.printStackTrace();
        }
    }

    public void displayEmployees() {
        String sql = "SELECT * FROM employees";

        try (Connection conn = connect();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            System.out.println("Employees:");
            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("id") + ", Name: " + rs.getString("name"));
            }

        } catch (SQLException e) {
            System.out.println("Failed to read employees.");
            e.printStackTrace();
        }
    }
}