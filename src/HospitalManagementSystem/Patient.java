package HospitalManagementSystem;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Patient {
    private final Connection connection;
    private final Scanner scanner;

    public Patient(Connection connection, Scanner scanner) {
        this.connection = connection;
        this.scanner = scanner;
    }

    public void addPatient() {
        try {
            System.out.print("Enter Patient Name: ");
            scanner.nextLine(); // Clear any leftover input
            String name = scanner.nextLine(); // Use nextLine() instead of next() to handle names with spaces

            System.out.print("Enter Patient's Age: ");
            int age = scanner.nextInt();

            System.out.print("Enter Patient's Gender: ");
            String gender = scanner.next();

            String query = "INSERT INTO patients(name,age,gender) VALUES(?,?,?)";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, name);
            preparedStatement.setInt(2, age);
            preparedStatement.setString(3, gender);
            int affectedRows = preparedStatement.executeUpdate();
            if (affectedRows > 0) {
                System.out.println("Patient added Successfully");
            } else {
                System.out.println("Failed to add patient");
            }

        } catch (InputMismatchException e) {
            System.out.println("Invalid input! Please enter a valid number for age.");
            scanner.nextLine(); // Clear the invalid input
        } catch (SQLException e) {
            System.out.println("Database error: " + e.getMessage());
        }
    }

    public void viewPatients() {
        String query = "SELECT * FROM patients";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();
            System.out.println("Patients: ");
            System.out.println("+---------------+---------------+-----------------+-------------------+");
            System.out.println("|      id       |       Name    |       Age       |        Gender     |");
            System.out.println("+---------------+---------------+-----------------+-------------------+");
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                int age = resultSet.getInt("age");
                String gender = resultSet.getString("gender");

                System.out.printf("| %-13d | %-13s | %-15d | %-17s |\n", id, name, age, gender);
            }
            System.out.println("+---------------+---------------+-----------------+-------------------+");
        } catch (SQLException e) {
            System.out.println("Database error: " + e.getMessage());
        }
    }

    public boolean getPatientById(int id) {
        String query = "SELECT * FROM patients WHERE id = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return true;
            }
        } catch (SQLException e) {
            System.out.println("Database error: " + e.getMessage());
        }
        return false;
    }
}