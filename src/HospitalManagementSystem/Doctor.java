package HospitalManagementSystem;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class Doctor {
    private final Connection connection;

    public Doctor(Connection connection) {
        this.connection = connection;
    }


    public void viewDoctors() {
        String query = "SELECT * FROM doctors";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();
            System.out.println("Doctors: "); // Fixed: was showing "Patients"
            System.out.println("+---------------+--------------------+-------------------------+");
            System.out.println("|   Doctor ID   |        Name        |    Specialization       |");
            System.out.println("+---------------+--------------------+-------------------------+");
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String specialization = resultSet.getString("specialization");

                // Fixed: removed %d for specialization (it's a String, not int)
                System.out.printf("| %-13d | %-18s | %-23s |\n", id, name, specialization);
            }
            System.out.println("+---------------+--------------------+-------------------------+");
        } catch (SQLException e) {
            System.out.println("Error viewing doctors: " + e.getMessage());
        }
    }

    public boolean getDoctorById(int id) {
        String query = "SELECT * FROM doctors WHERE id = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return true;
            }
        } catch (SQLException e) {
            System.out.println("Error checking doctor: " + e.getMessage());
        }
        return false;
    }

}
