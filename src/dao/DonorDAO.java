package dao;

import model.Donor;
import util.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DonorDAO {

    public void registerDonor(Donor donor) {
        String query = "INSERT INTO donors (name, age, organ, status) VALUES (?, ?, ?, ?)";
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, donor.getName());
            statement.setInt(2, donor.getAge());
            statement.setString(3, donor.getOrgan());
            statement.setString(4, "pending"); // Default status
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Donor> getAllDonors() {
        List<Donor> donors = new ArrayList<>();
        String query = "SELECT * FROM donors";
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Donor donor = new Donor();
                donor.setId(resultSet.getInt("id"));
                donor.setName(resultSet.getString("name"));
                donor.setAge(resultSet.getInt("age"));
                donor.setOrgan(resultSet.getString("organ"));
                donor.setStatus(resultSet.getString("status"));
                donors.add(donor);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return donors;
    }

    public void updateDonorStatus(int donorId, String status) {
        String query = "UPDATE donors SET status = ? WHERE id = ?";
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, status);
            statement.setInt(2, donorId);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
