package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    // These should be externalized in a real application
    private static final String URL = "jdbc:postgresql://localhost:5432/healthcare";
    private static final String USER = "your_username";
    private static final String PASSWORD = "your_password";

    public static Connection getConnection() throws SQLException {
        try {
            Class.forName("org.postgresql.Driver");
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (ClassNotFoundException e) {
            // This is a runtime exception because the driver should always be available.
            throw new RuntimeException("PostgreSQL JDBC Driver not found.", e);
        }
    }
}
