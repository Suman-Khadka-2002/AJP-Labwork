package JavaDatabase;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class StudentCRUDApp extends JFrame {
    private JTextField idField, nameField, ageField, districtField;
    private JTextArea resultArea;
    private Connection connection;

    public StudentCRUDApp() {
        initializeUI();
        initializeDatabase();
    }

    private void initializeUI() {
        setTitle("Student CRUD Application");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);
        setLayout(new BorderLayout());

        JPanel inputPanel = new JPanel(new GridLayout(4, 2));
        inputPanel.add(new JLabel("ID:"));
        inputPanel.add(idField = new JTextField());
        inputPanel.add(new JLabel("Name:"));
        inputPanel.add(nameField = new JTextField());
        inputPanel.add(new JLabel("Age:"));
        inputPanel.add(ageField = new JTextField());
        inputPanel.add(new JLabel("District:"));
        inputPanel.add(districtField = new JTextField());

        JButton addButton = new JButton("Add");
        JButton viewButton = new JButton("View All");
        JButton updateButton = new JButton("Update");
        JButton deleteButton = new JButton("Delete");

        addButton.addActionListener(e -> addStudent());
        viewButton.addActionListener(e -> viewAllStudents());
        updateButton.addActionListener(e -> updateStudent());
        deleteButton.addActionListener(e -> deleteStudent());

        JPanel buttonPanel = new JPanel(new FlowLayout());
        buttonPanel.add(addButton);
        buttonPanel.add(viewButton);
        buttonPanel.add(updateButton);
        buttonPanel.add(deleteButton);

        resultArea = new JTextArea(8, 10);
        JScrollPane scrollPane = new JScrollPane(resultArea);

        add(inputPanel, BorderLayout.NORTH);
        add(buttonPanel, BorderLayout.CENTER);
        add(scrollPane, BorderLayout.SOUTH);

        setVisible(true);
    }

    private void initializeDatabase() {
        try {
            String jdbcUrl = "jdbc:mysql://localhost:3306/studentrecord";
            String username = "root";
            String password = "";

            connection = DriverManager.getConnection(jdbcUrl, username, password);
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Failed to connect to the database");
            System.exit(1);
        }
    }

    private void addStudent() {
        try {
            int id = Integer.parseInt(idField.getText());
            String name = nameField.getText();
            int age = Integer.parseInt(ageField.getText());
            String district = districtField.getText();

            String sql = "INSERT INTO student (id, name, age, district) VALUES (?, ?, ?, ?)";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                preparedStatement.setInt(1, id);
                preparedStatement.setString(2, name);
                preparedStatement.setInt(3, age);
                preparedStatement.setString(4, district);

                int rowsAffected = preparedStatement.executeUpdate();
                if (rowsAffected > 0) {
                    resultArea.setText("Student added successfully");
                } else {
                    resultArea.setText("Failed to add student");
                }
            }
        } catch (NumberFormatException | SQLException e) {
            e.printStackTrace();
            resultArea.setText("Invalid input. Please check your input and try again.");
        }
    }

    private void viewAllStudents() {
        try {
            String sql = "SELECT * FROM student";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql);
                 ResultSet resultSet = preparedStatement.executeQuery()) {

                StringBuilder resultText = new StringBuilder();
                while (resultSet.next()) {
                    int id = resultSet.getInt("id");
                    String name = resultSet.getString("name");
                    int age = resultSet.getInt("age");
                    String district = resultSet.getString("district");

                    resultText.append("ID: ").append(id).append(", Name: ").append(name)
                            .append(", Age: ").append(age).append(", District:").append(district).append("\n");
                }

                if (resultText.length() > 0) {
                    resultArea.setText(resultText.toString());
                } else {
                    resultArea.setText("No students found");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            resultArea.setText("Failed to fetch students");
        }
    }

    private void updateStudent() {
        try {
            int id = Integer.parseInt(idField.getText());
            String name = nameField.getText();
            int age = Integer.parseInt(ageField.getText());
            String district = districtField.getText();

            String sql = "UPDATE student SET name=?, age=?, district=? WHERE id=?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                preparedStatement.setString(1, name);
                preparedStatement.setInt(2, age);
                preparedStatement.setString(3, district);
                preparedStatement.setInt(4, id);

                int rowsAffected = preparedStatement.executeUpdate();
                if (rowsAffected > 0) {
                    resultArea.setText("Student updated successfully");
                } else {
                    resultArea.setText("No matching student found to update");
                }
            }
        } catch (NumberFormatException | SQLException e) {
            e.printStackTrace();
            resultArea.setText("Invalid input. Please check your input and try again.");
        }
    }

    private void deleteStudent() {
        try {
            int id = Integer.parseInt(idField.getText());

            String sql = "DELETE FROM student WHERE id=?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                preparedStatement.setInt(1, id);

                int rowsAffected = preparedStatement.executeUpdate();
                if (rowsAffected > 0) {
                    resultArea.setText("Student deleted successfully");
                } else {
                    resultArea.setText("No matching student found to delete");
                }
            }
        } catch (NumberFormatException | SQLException e) {
            e.printStackTrace();
            resultArea.setText("Invalid input. Please check your input and try again.");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new StudentCRUDApp());
    }
}
