package JavaDatabase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class StudentRetrieval {
    public static void main(String[] args) {
        // JDBC URL, username, and password of MySQL server
        String jdbcUrl = "jdbc:mysql://localhost:3306/studentrecord";
        String username = "root";
        String password = "";

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            connection = DriverManager.getConnection(jdbcUrl, username, password);

            // SQL query to retrieve names of students in Kathmandu district
            String sql = "SELECT name FROM student WHERE district = ?";

            // Set the district parameter (e.g., Kathmandu)
            String targetDistrict = "Kathmandu";

            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, targetDistrict);

            // Execute the query
            resultSet = preparedStatement.executeQuery();

            // Process the results
            while (resultSet.next()) {
                String studentName = resultSet.getString("name");
                System.out.println("Student in Kathmandu: " + studentName);
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            // Close resultSet, preparedStatement, and connection in finally block
            try {
                if (resultSet != null) resultSet.close();
                if (preparedStatement != null) preparedStatement.close();
                if (connection != null) connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
